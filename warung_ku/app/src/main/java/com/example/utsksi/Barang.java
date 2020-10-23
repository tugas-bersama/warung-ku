package com.example.utsksi;

public class Barang {
    private long id;
    private String nama_barang;
    private String harga_barang;
    private String stok_barang;

    public Barang()
    {

    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nama_barang
     */
    public String getNama_barang() {
        return nama_barang;
    }

    /**
     * @param nama_barang the nama_barang to set
     */
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    /**
     * @return the merk_barang
     */
    public String getStok_barang() {
        return stok_barang;
    }

    /**
     * @param stok_barang the merk_barang to set
     */
    public void setStok_barang(String stok_barang) {
        this.stok_barang = stok_barang;
    }

    /**
     * @return the harga_barang
     */
    public String getHarga_barang() {
        return harga_barang;
    }

    /**
     * @param harga_barang the harga_barang to set
     */
    public void setHarga_barang(String harga_barang) {
        this.harga_barang = harga_barang;
    }

    @Override
    public String toString()
    {
        return  "Nama : "+ nama_barang +"\n"+"Harga : "+ harga_barang + "\n"+ "Stok    : "+stok_barang;
    }
}
