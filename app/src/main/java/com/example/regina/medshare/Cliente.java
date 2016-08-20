package com.example.regina.medshare;

public class Cliente {

	private String nome, 
			Rg, 
			cpf, 
			email, 
			tel,
			pass,
			rua,
			Num,
			city, 
			state,
			bairro,
			CEP;

	@Override
	public boolean equals(Object o) {
		Cliente c = (Cliente) o;
		return c.email.equals(email) && c.pass.equals(pass);
	}

	public void setNome(String that){
		this.nome = that;
	}
	public void setRG(String that){
		this.Rg = that;
	}
	public void setCPF(String that){
		this.cpf = that;
	}
	public void setEmail(String that){
	this.email = that;
}
public void setTel(String that){
	this.tel = that;
}
public void setPass(String that){
	this.pass = that;
}
public void setRua(String that){
	this.rua = that;
}
public void setNum(String that){
	this.Num = that;
}
public void setBairro(String that){
	this.bairro = that;
}
public void setCidade(String that){
	this.city = that;
}
public void setCEP(String that){
	this.CEP = that;
}
public void setEstado(String that){
	this.state = that;
}
	
	public String getNome() {
		return nome;
	}
	
	public String getRG(){
		return Rg;
	}
	public String getCPF(){
		return cpf;
	}
	public String getEmail(){
		return email;
	}
	public String getTel(){
		return tel;
	}
	public String getPass(){
		return pass;
	}
	public String getRua(){
		return rua;
	}
	public String getNum(){
		return Num;
	}
	public String getBairro(){
		return bairro;
	}
	public String getCEP(){
		return CEP;
	}
	public String getCidade(){
		return city;
	}
	public String getEstado(){
		return state;
	}
}
