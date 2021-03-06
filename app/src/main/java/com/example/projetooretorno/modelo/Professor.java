package com.example.projetooretorno.modelo;

import android.net.Uri;

import com.example.projetooretorno.helper.Conexao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Professor {

    private String id;
    private String nome;
    private String email;
    private String caminhoFoto;
    private String estado;
    private String cidade;
    private String endereco;

    @Override
    public String toString() {
        return "Professor{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", caminhoFoto='" + caminhoFoto + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Professor() {
    }

    public Professor(String nome, String email, String endereco, String caminhoFoto) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.caminhoFoto = caminhoFoto;
    }

    public void atualizar(){
        FirebaseDatabase firebaseDatabase = Conexao.getFirebaseDatabase();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        DatabaseReference professoresRef = databaseReference.child("Professor").child(getId());

        Map<String, Object> valorProfessor = converterParaMap();
        professoresRef.updateChildren(valorProfessor);
    }

    public Map<String, Object> converterParaMap(){
        HashMap<String, Object> professorMap = new HashMap<>();
        professorMap.put("email", getEmail());
        professorMap.put("nome", getNome());
        professorMap.put("id", getId());
        professorMap.put("caminhoFoto", getCaminhoFoto());

        return professorMap;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
