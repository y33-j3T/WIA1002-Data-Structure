package linkedlistdecoder;

public class LinkedListDecoder {

    MyDoublyLinkedList<Character> list = new MyDoublyLinkedList<>();

    public MyDoublyLinkedList<Character> getList() {
        return list;
    }

    public void setList(MyDoublyLinkedList<Character> list) {
        this.list = list;
    }

    public void addString(String str) {
        String[] strArr = str.split("");

        for (String strChar : strArr) {
            list.addLast(strChar.charAt(0));
        }
    }

    public void A(char a, char b, Integer n) {
        list.add(list.getIndex(a, n) + 1, b);
    }

    public void B(char a, Integer i, char b, Integer j) {
        int start = list.getIndex(a, i);
        int end = list.getIndex(b, j);
        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }
        for (int x = 0; x < end - start - 1; x++) {
            list.remove(start + 1);
        }
    }

    public void C() {
        MyDoublyLinkedList<Character> newList = new MyDoublyLinkedList<>();
        int poolCount = list.getSize() % 2 == 0 ? list.getSize() : list.getSize() - 1;
        for (int i = 0; i < poolCount / 2; i++) {
            float a = list.removeFirst().toString().charAt(0);
            float b = list.removeFirst().toString().charAt(0);
            newList.addLast((Character) (char) (Math.ceil((a + b) / 2)));
        }
        if (list.getSize() != 0) {
            newList.addLast(list.removeFirst().toString().charAt(0));
        }
        list = newList;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {

        // challenge 1
        LinkedListDecoder lld = new LinkedListDecoder();
        lld.addString("bwoaeomkvhbhycgzcomhdtfwkermaiahavxlrkcsxlveyugxtmejpouormzrsoiumomhtczeihailvtrqi"
                + "wfonaudbispjhiobesjhyzipdcjcwyxvrakvnwvwjzajpzfwairbshydklhemqwqbvvdkbtjelvylbjaoootdibnfuwozlkae"
                + "udgbfbondkyrrjtjrchksvnzbyblxebsyacmhstwuvggikiqsgqtwojndfawnawfjazlcvxtaufkfpwzumdfqzgbxcyoijbdo"
                + "vrjzxhazhwmdwzyrcxxmwcqxrpmxnpvrlflwyjxdchxmeeboewndsttkqhbrskglwwucuevjykghkvqybkvfflawzzqrzujql"
                + "qhmezcikyculxqqpqivcapnhtseauqctujqtjgopaswlytksdfjokohfrzqjpxypifiltvitglqlafrkfojakpuebanpnunxz"
                + "wcpvmosvcrlqsmpcjdnfwvqintioojhvlhtlljyzsmmpncabyixprutekfngofobnraqcqlidsacbqblrtndmsxudceshurgk"
                + "tayswgeiuvogzdxydkuyyohxeutxtpojxbjieaogkhfqcaehumsreibiwweqimalyzksqtrlwwmxgrxusdylqxfkogzihicft"
                + "deerpqvrxtppzmzhulykmhlostutrvtxdenaprokanfnugwzyqcznpgwscggjqidgfgzteixuyupzaomsdgdpgbwvwkuacawr"
                + "winzuzxtkpruaisqhoxwffmwzwzegkqcjtpocejrgyudvnbnhgyghiupliygdtcmuluwkigsamuyrbbhmtomvjdqusopqgvyp"
                + "vfqjgjvdbteyvydflxjpmzfcptfpnmucvqecsygqxsnszptnaqwoxdmbzjaevysxpcgxmnekhvufqfnwgnudvprqbqlgqedmk"
                + "orgrgdsthhusmxoajctzkmgzksfkbpkxmxyosfjrlmfqhitbeaxyzqqcgukunlzamebffymdhhutetveosobciisyitipfwww"
                + "kaibshklpimfrplhkdvvqvcnsinnnzncvjnndocvmhnbbrlnyzygzrxduebyuvkrxnlmbgdxjrncsbajbezvralfzfdwohsqg"
                + "phkvgltietkjakpcxnujfsnrwhgtizhielgbjvdkbspfoljxyorprppxcdcjdttxmlypyylraxfessfbyujiilzmhsqehbmeh"
                + "jaycejkgdnwlmsldkdwpnvhzvnozrfjnxcjxedrlfwdmfeicbqgbap");
        System.out.println(lld.toString());

        // challenge 2
        LinkedListDecoder lld2 = new LinkedListDecoder();
        lld2.addString("mvdokrirkezrwulsdnnepzsclanfybdhzahtcwgxptlnwvnfavkznmmsuhdydmujelcwhvlltfzxawszhg"
                + "lpomgywkhxeynyglbbmbjhltkjgeavkjqevhkbcmrjpwzurbzhjcfytgncyuwemdxotlodhcnmoebyilsgypurbudecynlnpv"
                + "etjpsvsuvxbsuzorocxrrlzguxcbcyegxtlmwweukauzxdsejqaputsidcokyocwujkihxaxftseecqcsojfetlgntqquzlxe"
                + "dkganxwrfetcuzawzfdlqwknwzkdqwdphgrpeezjlccxaqbfgcibyotzoyjzuiiilnzraafqbgyugfdpqwkpaqvhqrlfwbqbp"
                + "vbrrxenaojiqzjghtcybpnzfulgdqfonridrpgpvpbktgfmdqvddmnxmpjkrwhdrvdlgbugumgqaaiilqbkoigcnkjtyoxfin"
                + "ctwsecmitpubcwxelbnltffrhcnvutgxrwsfifduxzeyyxedqnshwklyrnsfabkaixopoqkqguynzpfxyxmymtrhlogqyibag"
                + "tbmwhsvtdllooavycczwihtdsopqvdrikwwssudophbtaugmmlovxrvonnttfedsnjswywjoyhuqmohjvlwnqtnorylesrzrz"
                + "bfqjxqfomnuhqnbjpfvrxpsbpujjksjecijxhbdicybymsiwzweggqcgdprmrbnsaxwlmofogypmzwgxawqrvjhakqisouzhh"
                + "samzudfwaunrzqozuxvxzfpbpvikanssvyczwnscazyndcygdurutgdhxsveacnfbeauyjezscjwvrbjqkxoomenrwpejzboe"
                + "tjsfiprhmtyyhmlhyqgdleaegrkvsqahgvqitbxltprmnvbumikwurmekohykkgxmpahhzpsjskkmemstqjaxcdgngbfiopbc"
                + "ptmkkzhbdztjxhyzalyxjsxcjcimizikrsexmperhpjblgmojnrioqevkxlsaydpdkwilftkxbrvwvcflkqiafdvallktjtit"
                + "ikchoiipkfmcazjkuddcolzafgxyhvtenrashfvbicgqpiaftrphjypevlmiasljbgunhaomohjodgffoufzfoukvutbjvxpw"
                + "vmvubdxvqvuqbhlfdqzfundvbjltymzvqusuvltmbfadjjtrpgnjjpoxvkkvenmyheyckwdidhweifiyrcrfyextwiemjqnwp"
                + "vytwaiihaitxfrqssnpoqfkoawgulzkmgzcqzpcxsecisqmgwqchsa");

        lld2.A('t', 'm', 34);
        lld2.A('d', 'r', 28);
        lld2.A('j', 's', 44);
        lld2.A('v', 'k', 16);
        lld2.A('w', 'm', 26);
        lld2.A('l', 'y', 44);
        lld2.A('z', 'd', 4);
        lld2.A('d', 'n', 15);
        lld2.A('f', 'u', 46);
        lld2.A('e', 'y', 7);
        lld2.A('w', 'i', 35);
        lld2.A('x', 'k', 37);
        lld2.A('a', 'l', 6);
        lld2.A('w', 's', 50);
        lld2.A('q', 'r', 31);
        lld2.A('t', 'e', 2);
        lld2.A('n', 'z', 16);
        lld2.A('l', 'g', 11);
        lld2.A('t', 'j', 30);
        lld2.A('m', 'x', 21);
        lld2.A('f', 'o', 41);
        lld2.A('o', 'i', 2);
        lld2.A('k', 'n', 39);
        lld2.A('o', 'p', 34);
        lld2.A('x', 'z', 19);
        lld2.A('u', 'c', 45);
        lld2.A('i', 'u', 32);
        lld2.A('e', 'w', 47);
        lld2.A('l', 'z', 39);
        lld2.A('a', 's', 13);
        lld2.A('h', 'q', 17);
        lld2.A('v', 'b', 25);
        lld2.A('f', 'j', 6);
        lld2.A('l', 'u', 3);
        lld2.A('j', 'w', 27);
        lld2.A('v', 'o', 24);
        lld2.A('y', 'b', 46);
        lld2.A('t', 'l', 49);
        lld2.A('f', 'i', 1);
        lld2.A('b', 'c', 25);
        lld2.A('r', 's', 16);
        lld2.A('x', 'm', 22);
        lld2.A('h', 'c', 49);
        lld2.A('q', 'g', 3);
        lld2.A('x', 'k', 15);
        lld2.A('e', 'y', 32);
        lld2.A('y', 'h', 36);
        lld2.A('d', 'x', 15);
        lld2.A('d', 'z', 24);
        lld2.A('r', 'c', 6);
        System.out.println(lld2.toString());

        // challenge 3
        LinkedListDecoder lld3 = new LinkedListDecoder();
        lld3.addString("bbwrsbldvpmgvteszeynvryahwnmyxuuslmiewuuiejzpmdtswyxtwtybggnorubwpbfgttjnpssxpaajr"
                + "xynafocntokemlvsaqrwrdzjmduotqneihaqlzygoikyltfgwnrirzqpjsngcqrzrpcockjzovyrbkiycwvqypdhxonhfrfyr"
                + "wccatvpusgibcnhnblwlrczqljdxihahiwwswfbynvqnmnssjmbdoufhlwegpjmdokmgevupldbkjhwqttxztqhukddqfeeun"
                + "wboowjbugqwfhwclqekcjbrioaeerzlagbhkyxvsdvrpobupnzfywdcnwreonqgpczrtczudpyvfmvdcpsoysnynyybngstle"
                + "akmailfvvrhmzbmasosszsekzlgekzuhozopuhytnskeejvirtefvwqxoaddalkqkjjoindnsjznqabljazoaiihwugdnulae"
                + "mhvmictxagqphrcbqmouxcbvefndhmqjcwlbqqjilijkesjupamxpbnuqozwdcpawplsliylvlcmscxhqivoyhlaffkdfcrfr"
                + "lckgjclcotgjwqvwxyswbjtjdywkdqzssqvzyxfpwqriczxmtlgrbhvfxjhgpjmijazxrjidphcopgnzsfscdqaazystmrkzz"
                + "axfevjuyxsxkmmxqddvfvegfbtnnxrjnvommjxrjxpdqywmehomlmagkjvortjvhhhvkkvfutvgsslvqgrcbgdwgklnhhwtbx"
                + "pbzaelzltssnmydykgpekrhfybtehpeeehtoflteotzvpwowakpedgbqvpkbgqfjuusuukacdzbmkvjdhpkxktzsemvxipdjw"
                + "xifvyylcnqkefrdyrjguvoofdlsrpgkayfslbryhspvtukkqcatuyrqnqgfyihjmucovbxwaopwoglcaaotmbpjbvuzdiepba"
                + "kpsuqdsnxbqaigcxiknjscizxgrwdptixjvgakkrpgxqctsmpbwmalfuamqjsgxskmwjekbfpeydxixgqmnnfbiarwotaydkf"
                + "nxqwhofskeqtevxfeofiuxsuvcmrhvlakqzynzldxgcmhxhxehowibyzcvclynhortbjdpwdiuiubqoocrdecctngiyxzhjcr"
                + "uipbipuaouqlrhsahphficzzyelihluiguzqzlqujmdigaftmdynvbmcretyehikvlozzftibxetkwnkrryfyxwigzmkuxffm"
                + "andghtlzilopmutzuuunngacglehxiejmifrwdtzfmfufttxojbgac");
        lld3.A('q', 'n', 48);
        lld3.A('f', 'b', 32);
        lld3.B('a', 45, 'h', 45);
        lld3.B('z', 33, 'l', 35);
        lld3.A('d', 'c', 8);
        lld3.A('p', 'z', 8);
        lld3.A('p', 'w', 45);
        lld3.A('t', 'p', 44);
        lld3.A('x', 'e', 4);
        lld3.A('q', 'u', 7);
        lld3.A('e', 'b', 2);
        lld3.A('i', 'w', 19);
        lld3.A('b', 'w', 28);
        lld3.A('m', 'b', 15);
        lld3.A('z', 'f', 7);
        lld3.A('u', 'n', 47);
        lld3.A('n', 'd', 16);
        lld3.B('a', 35, 'j', 34);
        lld3.A('p', 'v', 5);
        lld3.A('z', 'w', 30);
        lld3.B('h', 8, 'v', 7);
        lld3.A('y', 'r', 16);
        lld3.A('n', 'b', 33);
        lld3.A('e', 't', 36);
        lld3.A('d', 'h', 3);
        lld3.B('f', 6, 'c', 5);
        lld3.B('n', 5, 'r', 7);
        lld3.B('m', 8, 'b', 6);
        lld3.A('j', 'u', 27);
        lld3.A('a', 'g', 19);
        lld3.A('r', 'i', 22);
        lld3.A('i', 'j', 21);
        lld3.A('j', 'g', 14);
        lld3.A('q', 'v', 4);
        lld3.B('r', 13, 'd', 11);
        lld3.B('p', 15, 'q', 13);
        lld3.A('q', 'w', 5);
        lld3.B('u', 13, 'i', 12);
        lld3.B('l', 13, 'b', 12);
        lld3.B('v', 12, 'l', 13);
        lld3.A('a', 'e', 16);
        lld3.A('p', 'e', 10);
        lld3.A('f', 'e', 5);
        lld3.A('i', 'g', 6);
        lld3.A('p', 's', 13);
        lld3.A('y', 'f', 5);
        lld3.A('c', 'w', 2);
        lld3.A('o', 'u', 16);
        lld3.A('i', 'j', 9);
        lld3.B('r', 13, 'g', 12);
        System.out.println(lld3.toString());

        // challenge 4
        LinkedListDecoder lld4 = new LinkedListDecoder();
        lld4.addString("nfjbxouiasagueqxpfieeiygopuoisyzahnntuguhcxelvtqqplkvdxplrnlnqlgidcvncllqwitciqvvd"
                + "ceqniqjlpwfzpfmlfrqwbaltnfckimbfkqbppqiivbpokzmtjgvlktzxohhruftzhnbsmcjoxguhfolnfqtougprkrsdcgcyn"
                + "zptqcxoafxetrezcsipfbzevjfrpbphcemwtwtxydokkdcsnvqlloqisnvniumliuhvmdrokbhxadlqmbmiywolhpnadkvlta"
                + "hwncbdeyvpfluseugkwzsjuzdhgwoqiovuphzfkzqrhrtigcybgrsmqjngfjqvadpaplfvomefnipjpiypvuhohpaxftqvwlb"
                + "xyuvhxtgdyypjfzcpsnbklrtnctrghzdnbiuwcnucxthbibjsielandgujamkkgjlvymaglayyqedqfkzsoywvxglolxxatoe"
                + "ydzozqsgiqockssxbezzwwjhkzxdmwpjifnkyxueozogjguaidfshnlwytfcxmfgebrhixjaifajvurqrlxztotlyhmhoerhz"
                + "hcgajjhptmbdftrulzlvaxwzmvxowjuaxxakrsnzskxtbhtrwzjhqlocwbycwnyxvtfkojvqhbnmyatxssqekgkzikueynpwn"
                + "ixgqysshsruqdctawonigwxfpdiftqyhzdlmncblherlzqcsfjvbndmbpkcvuttgwdnoyhveaniuionvdwrfthmmveqgdpkdq"
                + "bquoekmaajujuroextabhqwkjjvezxdmxngzxcmpijewcoispmyognlvrrdliqcaaumgkatuftgdrbjwaeqzdvnxznfkvkslj"
                + "koewiazlutupvecvfmzfwhqitmxjaepxwgvniemisriyykbgmaiqidfmlyqkiuydyxfgqpacplayycaihdyicgtlszrvmkjpd"
                + "ipdofxkvoeqodltuwsgybnnolbsqjoefmmbcfsydnrhftukddofkdprmhrbjzslqqzwzazjfoeuegxwtdwstahbdphvmsbagi"
                + "ssvykpetcrkicfrtiyrxakerpvksossmcbcdehyorzwkpvjcchtspelyhnglnxfayjpuwuxwfsuekystmjsvmcirbprwigvtt"
                + "hjtsfjkgsbuscknvzbgynxsacbwmugqeaqurvifwrfmvwpsumysmirjrdtbqjvdegcjevhxqmdjshdjmuojynrqrjfejdrkmv"
                + "ujpyvptygjnczvoeqpgzzvwwazcsfqaojpbwulkkmqfrcgzlriabjepwnqbmutpvwhbbaeyablkduzhzgozryhjhantcezefu"
                + "hrxktcmfcrlwxhuiyuihzbevsqxwhgidcbkfsfjjwzmuwfovyebsrgsomdqgxdmwoncauegoycbpuawggayezxrxotjgryxnm"
                + "hadanaxkpdrkbdgrlngtlkrxkuvcmqbepqlsnycdxchbjdgiowmblozlneexbpyufnblwhjxacoymcwwlzydmzrfspkexkotv"
                + "asmuosybzrhpelwzjkwrnbt");
        lld4.A('q', 'c', 51);
        lld4.C();
        lld4.A('l', 'x', 26);
        lld4.A('h', 'e', 1);
        lld4.A('l', 'e', 2);
        lld4.A('r', 'l', 18);
        lld4.A('w', 't', 14);
        lld4.A('h', 'w', 7);
        lld4.A('t', 'm', 26);
        lld4.A('w', 'x', 18);
        lld4.A('f', 'v', 15);
        lld4.A('r', 'b', 7);
        lld4.A('w', 'k', 18);
        lld4.A('c', 'o', 5);
        lld4.A('d', 'i', 25);
        lld4.A('n', 'v', 28);
        lld4.A('d', 'g', 16);
        lld4.C();
        lld4.A('f', 'w', 9);
        lld4.A('t', 'q', 7);
        lld4.A('o', 'q', 3);
        lld4.C();
        lld4.A('y', 's', 3);
        lld4.C();
        lld4.A('b', 'm', 2);
        lld4.A('j', 'b', 3);
        lld4.C();
        lld4.A('g', 'p', 1);
        lld4.A('v', 'b', 1);
        lld4.C();
        System.out.println(lld4.toString());
    }

}
