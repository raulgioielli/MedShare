package com.example.regina.medshare;

/**
 * Created by Juliana SO Q NAO HUE HUEHUEHUEUHE on 20/08/2016.
 */
public class Produto {
    private String
            Produto_Nome,
            Marca,
            Descricao,
            Foto,
            Fornecedor,
            Freq,
            Date_Ven,
            Cliente;
    private int
            Tipo,
            Trans,
            Disp,
            Novo,
            Pre_Alu,
            Prec;

    public void setProduto_Nome(String str){
        this.Produto_Nome = str;
    }

    public void setMarca(String str){
        this.Marca = str;
    }

    public void setDescricao(String str){
        this.Descricao = str;
    }

    public void setFoto(String str){
        this.Foto = str;
    }

    public void setFornecedor(String str){
        this.Fornecedor = str;
    }
    public void setFreq(String str){
        this.Freq = str;
    }
    public void setDate_Ven(String str){
        this.Date_Ven = str;
    }
    public void setCliente(String str){
        this.Cliente = str;
    }

    public void setTipo(int str){
        this.Tipo = str;
    }
    public void setDisp(int str){
        this.Disp = str;
    }
    public void setTrans(int str){
        this.Trans = str;
    }
    public void setNovo(int str){
        this.Novo = str;
    }
    public void setPre_Alu(int str){
        this.Pre_Alu = str;
    }
    public void setPrec(int str){
        this.Prec = str;
    }

    public String getProduto_Nome(){
        return Produto_Nome;
    }
    public String getMarca(){
        return Marca;
    }
    public String getDescricao(){
        return Descricao;
    }
    public String getFoto(){
        return Foto;
    }
    public String getFornecedor(){
        return Fornecedor;
    }
    public String getFreq(){
        return Freq;
    }
    public String getDate_Ven(){
        return Date_Ven;
    }
    public String getCliente(){
        return Cliente;
    }
    public int getTipo(){
        return Tipo;
    }
    public int getTrans(){
        return Trans;
    }
    public int getDisp(){
        return Disp;
    }
    public int getNovo(){
        return Novo;
    }
    public int getPre_Alu(){
        return Pre_Alu;
    }
    public int getPrec(){
        return Prec;
    }

}
