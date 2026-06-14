package model;

import linkedlist.*;

public class AppData {

    public Order order;
    public MemberLL memberList;
    public Customer customer;
    public ServiceLL serviceSatuan;
    public ServiceLL serviceKiloan;
    public Owner owner;
    public Admin admin;
    public Customer currentCustomer;
    public OrderLL orderList;
    public Member currentMember;

    // TOTAL PENDAPATAN SEMUA TRANSAKSI
    public double totalPendapatan = 0;
    // kiloan
    public double totalCuciBasahKiloan = 0;
    public double totalCuciKeringKiloan = 0;
    public double totalCuciKeringSetrikaKiloan = 0;
    public double totalSetrikaKiloan = 0;
    // satuan
    public double totalCuciKeringSatuan = 0;
    public double totalCuciKeringSetrikaSatuan = 0;
    public double totalSetrikaSatuan = 0;
}