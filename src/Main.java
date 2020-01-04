import abstracts.AbstractAddressTransverter;
import abstracts.AddressTransverter;
import entity.*;

public class Main {

    public static void main(String[] args) {

        AbstractAddressTransverter abstractAddressTransverter=new AddressTransverter(2,2,3);

        (abstractAddressTransverter).transform(new VirtualAddress(10,14,121));
        (abstractAddressTransverter).transform(new VirtualAddress(12,14,122));
        (abstractAddressTransverter).transform(new VirtualAddress(15,144,124));
        (abstractAddressTransverter).transform(new VirtualAddress(103,164,194));
        (abstractAddressTransverter).transform(new VirtualAddress(124,154,132));
        (abstractAddressTransverter).transform(new VirtualAddress(153,154,253));

        ((AddressTransverter) abstractAddressTransverter).view();


    }
}
