package com.flinics.history.ui.model;

public class History {
    private String _id;
    private String _name;
    private String _gender;
    private String _age;

    public History(
            String id,
            String name,
            String gender,
            String age
    ){
        _id = id;
        _name = name;
        _gender = gender;
        _age = age;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String gender) {
        this._gender = gender;
    }

    public String getAge() {
        return _age;
    }

    public void setAge(String age) {
        this._age = age;
    }

    public String getDescription(){
        return String.format("Paciente %1$s de %2$s años de edad", _gender, _age);
    }
}
