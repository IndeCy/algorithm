package easy;

import main.Object.ProviderSonDO;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ProviderSonDO p1 = new ProviderSonDO();
        p1.setParentName("aaa");
        p1.setSonName("b");
        ProviderSonDO p2 = new ProviderSonDO();
        p2.setParentName("aaa");
        p2.setSonName("bb");
        ProviderSonDO p3 = new ProviderSonDO();
        p3.setParentName("aaa");
        p3.setSonName("aaa");
        ProviderSonDO p4 = new ProviderSonDO();
        p4.setParentName("aaa");
        p4.setSonName("aaa");
        ProviderSonDO p5 = new ProviderSonDO();
        p5.setParentName("aaa");
        p5.setSonName("ddd");
        List<ProviderSonDO> providerSonDOS = new ArrayList<>();
        List<ProviderSonDO> sortProviderSonDOS;
        providerSonDOS.add(p1);
        providerSonDOS.add(p2);
        providerSonDOS.add(p3);
        providerSonDOS.add(p4);
        providerSonDOS.add(p5);
        providerSonDOS.stream().forEach(providerSonDO-> System.out.println(providerSonDO.getParentName()+"::"+providerSonDO.getSonName()));
        System.out.println("----------------------");
        sortProviderSonDOS = sortProviderSonsV2(providerSonDOS);
        sortProviderSonDOS.stream().forEach(providerSonDO -> System.out.println(providerSonDO.getParentName()+"::"+providerSonDO.getSonName()));
    }


    private static List<ProviderSonDO> sortProviderSonsV2(List<ProviderSonDO> providerSonDOS){
        List<ProviderSonDO> sortList = new ArrayList<>();
        List<ProviderSonDO> notSortList = new ArrayList<>();
        for(ProviderSonDO providerSonDO : providerSonDOS){
            if(providerSonDO.getParentName().equals(providerSonDO.getSonName())){
                sortList.add(providerSonDO);
            }else{
                notSortList.add(providerSonDO);
            }
        }
        sortList.addAll(notSortList);
        return sortList;
    }
}
