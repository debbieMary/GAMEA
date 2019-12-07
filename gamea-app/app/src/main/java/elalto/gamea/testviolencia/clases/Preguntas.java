package elalto.gamea.testviolencia.clases;

public class Preguntas {
    String texto;
    Integer respuesta;

    public Preguntas(String texto, Integer respuesta) {
        this.texto = texto;
        this.respuesta = respuesta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Integer respuesta) {
        this.respuesta = respuesta;
    }
}
