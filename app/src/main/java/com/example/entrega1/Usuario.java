package com.example.entrega1;

import java.util.ArrayList;

public class Usuario {
    private String codigo;
    private String nombre;
    private String apellido;
    private String documento;
    private String edad;
    private String email;
    private String telefono;
    private String nacimiento;
    private String genero;
    private String estadoCivil;
    private ArrayList<String> gustos;
    private String equipoFavorito;
    private String peliculaFavorita;
    private String colorFavorito;
    private String comidaFavorita;
    private String libroFavorito;
    private String cancionFavorita;
    private String descripcion;

    // Constructor de la clase Usuario
    public Usuario(String codigo, String nombre, String apellido, String documento, String edad, String email, String telefono, String nacimiento, String genero, String estadoCivil, ArrayList<String> gustos, String equipoFavorito, String peliculaFavorita, String colorFavorito, String comidaFavorita, String libroFavorito, String cancionFavorita, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.gustos = gustos;
        this.equipoFavorito = equipoFavorito;
        this.peliculaFavorita = peliculaFavorita;
        this.colorFavorito = colorFavorito;
        this.comidaFavorita = comidaFavorita;
        this.libroFavorito = libroFavorito;
        this.cancionFavorita = cancionFavorita;
        this.descripcion = descripcion;
    }

    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public ArrayList<String> getGustos() {
        return gustos;
    }

    public void setGustos(ArrayList<String> gustos) {
        this.gustos = gustos;
    }

    public String getEquipoFavorito() {
        return equipoFavorito;
    }

    public void setEquipoFavorito(String equipoFavorito) {
        this.equipoFavorito = equipoFavorito;
    }

    public String getPeliculaFavorita() {
        return peliculaFavorita;
    }

    public void setPeliculaFavorita(String peliculaFavorita) {
        this.peliculaFavorita = peliculaFavorita;
    }

    public String getColorFavorito() {
        return colorFavorito;
    }

    public void setColorFavorito(String colorFavorito) {
        this.colorFavorito = colorFavorito;
    }

    public String getComidaFavorita() {
        return comidaFavorita;
    }

    public void setComidaFavorita(String comidaFavorita) {
        this.comidaFavorita = comidaFavorita;
    }

    public String getLibroFavorito() {
        return libroFavorito;
    }

    public void setLibroFavorito(String libroFavorito) {
        this.libroFavorito = libroFavorito;
    }

    public String getCancionFavorita() {
        return cancionFavorita;
    }

    public void setCancionFavorita(String cancionFavorita) {
        this.cancionFavorita = cancionFavorita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Gustos: " + String.join(", ", gustos) +
                "\nEquipo Favorito: " + equipoFavorito +
                "\nPelícula Favorita: " + peliculaFavorita +
                "\nColor Favorito: " + colorFavorito +
                "\nComida Favorita: " + comidaFavorita +
                "\nLibro Favorito: " + libroFavorito +
                "\nCanción Favorita: " + cancionFavorita +
                "\nDescripción: " + descripcion;
    }
}
