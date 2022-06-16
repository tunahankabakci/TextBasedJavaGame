package Models.Fields;

import Models.Characters.Character;

public abstract class Field implements IField {
    private int id;
    private String name;
    private Character character;
    private FieldType fieldType;

    public Field(int id, String name, FieldType fieldType) {
        this.id = id;
        this.name = name;
        this.fieldType = fieldType;
    }

    public Field(int id, String name, Character character, FieldType fieldType) {
        this.id = id;
        this.name = name;
        this.character = character;
        this.fieldType = fieldType;
    }

    public abstract boolean onField();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
