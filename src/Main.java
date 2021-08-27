public class Main {

    public static String[] model = new String[5];
    public static java.util.Scanner scan = new java.util.Scanner(System.in);
    public static int rice,chicken,fries;
    public static int restauranNet;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        while(true){
            System.out.println("==== My Restaurant ====");
            System.out.println("1. Menu");
            System.out.println("2. Payment");
            System.out.println("3. Exit");
            System.out.println("Choose>>");

            var inputMain = scan.nextInt();
            if (inputMain == 1){
                menuList();
                break;
            }
            else if (inputMain == 2){
                paymentList(rice,chicken,fries);
                break;
            }
            else if (inputMain == 3){
                System.out.println("Thank You and Good Bye!");
                break;
            }
            else{
                System.out.println("Not Available");
            }
        }

    }

    public static void menuList(){
        while(true){
            System.out.println("## MENU ##");
            System.out.println("1. Fried Rice [Rp 15.000]");
            System.out.println("2. Fried Chicken [Rp 30.000]");
            System.out.println("3. French Fries [Rp 20.000]");
            System.out.println("4. Back");
            System.out.println("Choose>>");

            var inputMenu = scan.nextInt();
            if (inputMenu == 1) {
                System.out.println("Quantity [1 - 10]");
                System.out.println("Qty>>> ");
                rice = scan.nextInt();

                if(rice < 1 || rice> 10){
                    System.out.println("Not Available");
                }else{
                    System.out.println("You have order :" + rice + "Fried Rice");
                }
            }
            else if (inputMenu == 2){
                System.out.println("Quantity [1 - 10]");
                System.out.println("Qty>>> ");
                chicken = scan.nextInt();

                if(chicken < 1 || chicken > 10){
                    System.out.println("Not Available");
                }else{
                    System.out.println("You have order :" + chicken + " Fried Chicken");
                }
            }
            else if (inputMenu == 3){
                System.out.println("Quantity [1 - 10]");
                System.out.println("Qty>>> ");
                fries = scan.nextInt();

                if(fries < 1 || fries > 10){
                    System.out.println("Not Available");
                }else{
                    System.out.println("You have order :" + fries + " French Fries");
                }
            }
            else if (inputMenu == 4){
                mainMenu();
                break;
            }
            else{
                System.out.println("Not Available");
            }
        }
    }

    public static void paymentList(int qtyrice, int qtychicken, int qtyfries){
        while(true){
            System.out.println("== Payment ==");
            var total_Rice = 0; var total_Chicken = 0; var total_Fries = 0;
            if(qtyrice == 0 && qtychicken == 0 && qtyfries == 0){
                System.out.println("You didn't order anything yet!");
                System.out.println("Please order at Menu");
                break;
            }
            total_Rice = 15_000 * qtyrice;
            total_Chicken = 30_000 * qtychicken;
            total_Fries = 20_000 * qtyfries;
            var subtotal = total_Rice + total_Chicken + total_Fries;

            System.out.println("Your Order");
            System.out.println("Fried Rice      : " + qtyrice + " : " + "Rp. " + total_Rice);
            System.out.println("Fried Chicken   : " + qtychicken + " : " + "Rp. " + total_Chicken);
            System.out.println("French Fries    : " + qtyfries + " : " + "Rp. " + total_Fries);
            System.out.println("Subtotal        : Rp" + subtotal);
            System.out.println();
            var payment = 0;
            var change = 0;
            do{
                System.out.println("Your Payment :");
                try{
                    payment = scan.nextInt();

                    if(payment < subtotal){
                        System.out.println("Payment Denied!");
                    }
                }
                catch (Exception e){
                    System.out.println("Your Payment :");
                    payment = scan.nextInt();
                }

            }while (payment < subtotal);

            if(payment == subtotal){
                System.out.println("Payment Success!");
                System.out.println("Thank You!");
            }
            else{
                change = payment -subtotal;
                System.out.println("Payment Success!");
                System.out.println("Your Change : Rp"+change);
                System.out.println("Thank You!");
            }

            /**
             saldo restoran setelah transaksi
             var restauranNettemp = payment - change;
             restauranNet += restauranNettemp;
             System.out.println(restauranNet);
             */

            break;
        }
    }


}
