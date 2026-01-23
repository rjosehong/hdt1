package hdt1;

public class Radio {
    private boolean estado;
	private String frecuencia;
	private double amEstacion;
	private double fmEstacion;
	private double[] botones;
	
	public boolean getEstado() {
		return estado;
	}
	
	public String getFrecuencia() {
		return frecuencia;
	}
	
	public double getAMEstacion() {
		return amEstacion;
	}
	
	public double getFMEstacion() {
		return fmEstacion;
	}
	
	public double[] getBotones() {
		return botones;
	}

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setAmEstacion(double amEstacion) {
        this.amEstacion = amEstacion;
    }

    public void setFmEstacion(double fmEstacion) {
        this.fmEstacion = fmEstacion;
    }

    public void setBotones(double[] botones) {
        this.botones = botones;
    }
}
