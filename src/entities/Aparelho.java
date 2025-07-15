package entities;

public class Aparelho {

    private String modelo;
    private String defeitoDeclarado;

    public Aparelho() {
    }

    public Aparelho(String modelo, String defeitoDeclarado) {
        this.modelo = modelo;
        this.defeitoDeclarado = defeitoDeclarado;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefeitoDeclarado() {
        return defeitoDeclarado;
    }

    public void setDefeitoDeclarado(String defeitoDeclarado) {
        this.defeitoDeclarado = defeitoDeclarado;
    }
}