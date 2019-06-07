package ifsc.edu.trabalho2;

public class ListaCompra {
    private String anoMes;
    private String desc;
    private int id;
    public void inserirAnoMes(String text){
        this.anoMes=text;
    }
    public String buscarAnoMes(){
        return  anoMes;
    }
    public void inserirDesc(String text){
        this.desc = text;
    }
    public String buscarDesc(){
        return desc;
    }
    public void inserirId(int id){
        this.id = id;
    }
    public int buscarId(){
        return id;
    }
}
