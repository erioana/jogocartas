package br.com.jogocartas.server.dbos;

public class PartidaUsuario {
	
	private int partidaID;
	private String nomePartida;
	private double valorPartida;
	private int usuarioID;
	private String nomeUsuario;
	
	public PartidaUsuario(){
		
	}
	
	public PartidaUsuario(int partidaID, String nomePartida, double valorPartida, int usuarioID,
			String nomeUsuario) {
		super();
		this.partidaID = partidaID;
		this.nomePartida = nomePartida;
		this.valorPartida = valorPartida;
		this.usuarioID = usuarioID;
		this.nomeUsuario = nomeUsuario;
	}
	public int getPartidaID() {
		return partidaID;
	}
	public void setPartidaID(int partidaID) {
		this.partidaID = partidaID;
	}
	public String getNomePartida() {
		return nomePartida;
	}
	public void setNomePartida(String nomePartida) {
		this.nomePartida = nomePartida;
	}
	public double getValorPartida() {
		return valorPartida;
	}
	public void setValorPartida(double valorPartida) {
		this.valorPartida = valorPartida;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePartida == null) ? 0 : nomePartida.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + partidaID;
		result = prime * result + usuarioID;
		long temp;
		temp = Double.doubleToLongBits(valorPartida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidaUsuario other = (PartidaUsuario) obj;
		if (nomePartida == null) {
			if (other.nomePartida != null)
				return false;
		} else if (!nomePartida.equals(other.nomePartida))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (partidaID != other.partidaID)
			return false;
		if (usuarioID != other.usuarioID)
			return false;
		if (Double.doubleToLongBits(valorPartida) != Double.doubleToLongBits(other.valorPartida))
			return false;
		return true;
	}

}
