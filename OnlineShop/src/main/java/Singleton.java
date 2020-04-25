import java.util.ArrayList;
import java.util.Calendar;
import static java.lang.Math.pow;

public class Singleton {
    
    private static ArrayList<Coupon> allCoupons;
    private static ArrayList<Product> allProducts;
    private static ArrayList<Request> allRequest;
    private static ArrayList<Sale> allSales;
    private static ArrayList<User>allUsers;
    private static ArrayList<Manager> allManagers;
    private static ArrayList<Buyer> allBuyers;
    private static ArrayList<Seller> allSellers;
    private static ArrayList<Category> allCategoriesAndSubcategories;
    private static ArrayList<Filter> allFilters;
    public static final String[] availableSorts = new String[3]{"Sort By Date", "Sort By Rating", "Sort By views"};
    private static String currentSortBeingUsed = "Sort By Views";
    private static ArrayList<Product> existingProducts; // products displayed in products page or offs page
    
    public Singleton() {
    
    }
    
    public void mainPage() {
        //123456
    }
    
    public int generateRandomNumber (int numberOfDigits) {
        int min = (int) pow(10, numberOfDigits-1);
        int max = (int) (pow(10, numberOfDigits) - 1);
        
        int result = (int) (Math.random() * (max - min + 1) + min);
        
        return result;
    }

    public class User {
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;
        private boolean isLoggedIn = false;
    }
    public class Seller extends User
    public class Buyer extends User
    public class Manager extends User
    public class Request{
         //elahe
        //enum for all types of requests
        enum requestType {
            CREATE_SELLER_ACCOUNT,
            EDIT_PRODUCT,
            ADD_PRODUCT,
            ADD_OFF,
            EDIT_OFF,
        }
        //variables here
        private String requestId;
        private user makerOfTheRequest;
        //the user that makes he request in the first palace
        private boolean isAccepted = false;
        //for checking if the request is accepted or not and is false at he beginning
        private requestType type;
        //sees what type the request is (the purpose of the request

        //constructor
        public Request( user user , requestType type) {
            this.type = type;
            this.user = user;
        }
        //methods start here

        //lists all requests
        public void listRequest(){}
        //checks if request exists or not
        public boolean isThereRequestWithId(String requestId){}
        //checks first if a request with this i exists and then displays the information for this request
        public void displayInfo(String requestId){}
        //checks if request exists , changes to true and then executes the action for the request type
        public void accept(String requestId){
            isAccepted = true;
        }
        //checks if request exists and then removes it from he request list
        public void decline(String requestId){}
    }
    public class Order {
        private String orderId;
        private DateAndTime dateAndTime;
        private ArrayList<Product> products;
        private int numOfProducts = 0;
        private double offSaleAmount, offCouponAmount, totalOffAmount = offSaleAmount + offCouponAmount;
        double totalPrice;
        
        public Order () {
        
        }
    }
    public class Log
    public class LogSell extends Log
    public class LogBuy extends Log
    public class Product{
        //enum for checking the product situation
        enum ProductSituation {
            CREATION_INVESTIGATION,
            EDITION_INVESTIGATION,
            ACCEPTED,
        }
        //variables here
        private ArrayList <Comment> commentList;
        private ArrayList <Sale> salesThatContainsIt;
        private String productId;
        //for showing how many views the peoduct has
        private int views = 0;
        private String timeAndDateOfCreation;
        private ProductSituation situation;
        //name of product
        private String name;
        //name of company
        private String company;
        private double price;
        private seller seller;
        //is product available or not
        private boolean isAvailable;
        private category category;
        //for storing special properties and their types
        private HashMap<String,String> specialProperties;
        private String info;
        private rating avgRating;

        //constructor
        public Product( String name, String company, double price, seller seller, category category, HashMap<String, String> specialProperties, String info) {
            this.name = name;
            this.company = company;
            this.price = price;
            this.seller = seller;
            this.category = category;
            this.specialProperties = specialProperties;
            this.info = info;
        }

        //methods start here

        //lists all products and shows them
        public void listProduct(){}

        //hecks if product exists or not
        public boolean isThereProductWithProductId (String productId){}

        //checks if product with that id exists and hen removes it
        public void removeProductById (String productId){}

        //checks if it exists and then shows its information
        public void displayInfoById (String productId){}

        //checks if i exists and then sends a request for manager to be edited
        public void editProductById (String productId){}

        //checks if exists and sends request
        public void addProduct (){}

        //
        public void showBriefAttributes(){}

        public void showAllAttributes (){}

        //compares the two products if they are in the same subcategory
        public void compare (String productId){}
    }
    public class Sale {
        private String offId;
        private ArrayList<Product> productList;
        private SaleState situation = SaleState.CREATION_INVESTIGATION;
        private DateAndTime startDateAndTime, endDateAndTime;
        private double percentage;
        
        public Sale(ArrayList<Product> productList, String endDateAndTime, double percentage) {
            this.offId = Integer.toString(generateRandomNumber(3));
            this.productList = productList;
            int startYear = Calendar.getInstance().get(Calendar.YEAR);
            int startMonth = Calendar.getInstance().get(Calendar.MONTH);
            int startDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int startHour = Calendar.getInstance().get(Calendar.HOUR);
            int startMinute = Calendar.getInstance().get(Calendar.MINUTE);
            int startSecond = Calendar.getInstance().get(Calendar.SECOND);
            this.startDateAndTime = new DateAndTime(startHour, startMinute, startSecond, startYear, startMonth, startDay);
            int endYear = Integer.parseInt(endDateAndTime.substring(0, 4));
            int endMonth = Integer.parseInt(endDateAndTime.substring(5, 7));
            int endDay = Integer.parseInt(endDateAndTime.substring(8, 10));
            int endHour = Integer.parseInt(endDateAndTime.substring(11, 13));
            int endMinute = Integer.parseInt(endDateAndTime.substring(14, 16));
            int endSecond = Integer.parseInt(endDateAndTime.substring(17,19));
            this.endDateAndTime = new DateAndTime(endHour, endMinute, endSecond, endYear, endMonth, endDay);
            this.percentage = percentage;
        }
    }
    public enum SaleState {
        CREATION_INVESTIGATION,
        EDITION_INVESTIGATION,
        ACCEPTED
    }
    public class Comment
    public class Category{
        //elahe
         //variables here
        private ArrayList<String> specialProperties;
        private ArrayList<Category> subCategory;
        private ArrayList<Product> productList;
        //name of the category
        private String name;

        //constructor
        public Category(ArrayList<String> specialProperties, ArrayList<Category> subCategory, ArrayList<Product> productList, String name) {
            this.specialProperties = specialProperties;
            this.subCategory = subCategory;
            this.productList = productList;
            this.name = name;
        }

        //methods start here
        public boolean isThereACategoryWithName (String name){}

        //also checks if category exits
        public void editCategory (String name){}

        //also checks if category exits
        public void removeCatergory (String name){}

        public void listCategories (){}

        public String toString (){}

    }
    public class Rating {
        public Buyer buyer;
        public double ratingNumber;
        public Product product;
        
        public Rating (double ratingNumber, Product product) {
            this.ratingNumber = ratingNumber;
            this.product = product;
        }
    }
    public class Coupon
    public class Filter{
        //elahe
        //enum for filter types
        enum FilterType{
            BY_CATEGORY,
            BY_SPECIAL_PROPERTY,
            BY_PROPERTY,  //EXCEPT FOR PRICE
            BY_PRICE,
        }
        //variables here
        private String name;
        private FilterType type;
        //for checking if user is choosing from the suggested filters or not
        private boolean isValid;
        //for checking if a filter is being used or not
        private boolean isBeingUsed;

        //constructor
        public Filter(FilterType type)
        {
            this.type = type;
        }

        //methods start from here

        //checks if filter is valid and then changes it to a filter that is being used
        public void updateValidFilters (){}

        //shows filters that are valid for being used
        public void showValidFilters (){}

        //also checks the validity of the filter
        public void filter(String command){}

        //shows the filters being used and also checks their validity
        public void showUsedFilters (){}

        // check if the filter exists and is being used then disable it
        public void disableFilter(String name){}


    }
    public class ShoppingCart {
        private ArrayList<Product> productsInCart;
        private int numberOfProducts = 0;
        private double offSaleAmount = 0, offCouponAmount = 0, totalOffAmount = 0
        private double totalPrice = 0
        private boolean hasEnoughCredit = true
        
        public ShoppingCart () { // constructor
        
        }
        
    }
    public class DateAndTime {
        public int hour;
        public int minute;
        public int second;
        public int year;
        public int month;
        public int day;
    
        public DateAndTime (int hour, int minute, int second, int year, int month, int day) {
            if (isValid()) {
                this.hour = hour;
                this.minute = minute;
                this.second = second;
                this.year = year;
                this.month = month;
                this.day = day;
            } else System.out.println("invalid date");
        }
        
        public boolean isLeap () {
            int year = this.year;
            if (year%4==0 && year%100==0 && year%400==0)
                return true;
            else
                return false;
        }
        
        public boolean isValid () {
            if (hour >= 24 || hour < 0 || minute >= 60 || minute < 0 || second >= 60 || second < 0 || month > 12 || month <= 0 || day <= 0)
                return false;
            else
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (day > 31) return false;
                        else return true;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (day > 30) return false;
                        else return true
                    case 2:
                        if ((this.isLeap() && day>29) || (!this.isLeap() && day>28)) return false;
                        else return true;
                }
        }
    }


}























