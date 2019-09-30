package com.flinics.history;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

//See: https://stackoverflow.com/a/53552095/1305745
public class VolleyQueueConfig {
    private static final String TAG = "VolleyQueueConfig";
    private static RequestQueue queue;

    public static RequestQueue getRequestQueue(final Context context) {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                useSSLCertificate(context.getResources(), R.raw.cert_flinics,
                        R.raw.cert_dst_root_ca_x3,
                        R.raw.cert_lets_encrypt_authority_x3_isrg_root_x1_signed);
            }
        }

        return queue;
    }

    private static void useSSLCertificate(final Resources resources, final int... rawCertificateResourceIds) {
        final CertificateFactory certificateFactory;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (final CertificateException exception) {
            final String errorMessage = "Failed to get an instance of the CertificateFactory.";
            // Log.e(TAG, errorMessage, exception);

            return;
        }

        int i = 0;
        final Certificate[] certificates = new Certificate[rawCertificateResourceIds.length];
        for (final int rawCertificateResourceId : rawCertificateResourceIds) {
            final Certificate certificate;
            try (final InputStream certificateInputStream = resources.openRawResource(rawCertificateResourceId)) {
                certificate = certificateFactory.generateCertificate(certificateInputStream);
            } catch (final IOException | CertificateException exception) {
                final String errorMessage = "Failed to retrieve the Certificate.";
                // Log.e(TAG, errorMessage, exception);

                return;
            }

            certificates[i] = certificate;
            i++;
        }

        final KeyStore keyStore;
        try {
            keyStore = buildKeyStore(certificates);
        } catch (final KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException exception) {
            final String errorMessage = "Failed to build the KeyStore with the Certificate.";
            // Log.e(TAG, errorMessage, exception);

            return;
        }

        final TrustManagerFactory trustManagerFactory;
        try {
            trustManagerFactory = buildTrustManager(keyStore);
        } catch (final KeyStoreException | NoSuchAlgorithmException exception) {
            final String errorMessage = "Failed to build the TrustManagerFactory with the KeyStore.";
            // Log.e(TAG, errorMessage, exception);

            return;
        }

        final SSLContext sslContext;
        try {
            sslContext = buildSSLContext(trustManagerFactory);
        } catch (final KeyManagementException | NoSuchAlgorithmException exception) {
            final String errorMessage = "Failed to build the SSLContext with the TrustManagerFactory.";
            // Log.e(TAG, errorMessage, exception);

            return;
        }

        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }

    private static KeyStore buildKeyStore(final Certificate[] certificates) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        final String keyStoreType = KeyStore.getDefaultType();
        final KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);

        int i = 0;
        for (final Certificate certificate : certificates) {
            keyStore.setCertificateEntry("ca" + i, certificate);
            i++;
        }

        return keyStore;
    }

    private static TrustManagerFactory buildTrustManager(final KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        final String trustManagerAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(trustManagerAlgorithm);
        trustManagerFactory.init(keyStore);

        return trustManagerFactory;
    }

    private static SSLContext buildSSLContext(final TrustManagerFactory trustManagerFactory) throws KeyManagementException, NoSuchAlgorithmException {
        final TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);

        return sslContext;
    }
}