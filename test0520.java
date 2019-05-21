class date{
    private int year,month,day;
    date(int year,int month,int day)//构造方法
    {
        if(judgeyear(year)){
            this.year=year;
        }
        else{
            System.out.println("年份输入错误！");
            return;
        }
        if(judeemonth(month)){
            this.month=month;
        }
        else{
            System.out.println("月输入错误！");
            return;
        }
        if(judgedays(day)){
            this.day=day;
        }
        else{
            System.out.println("日期输入错误！");
            return;
        }
    }
     void add(int days)//加日期方法
    {
        if(days<0||days>31){
            System.out.println("error");
        }
        day+=days;
        while(day>getDaysOfMonth(year,month)){
            day=day-getDaysOfMonth(year,month);
            month++;
            if(month>12){
                year++;
                month-=12;
            }
        }
    }
    void minus(int days)//减日期方法
    {
        if(days<0||days>31){
            System.out.println("error");
        }
        day-=days;
        while(day<1){
            month--;
            if(month<1){
                year--;
                month+=12;
            }
            day=getDaysOfMonth(year,month)+day;
        }
    }
    void print()//返回日期对应字符串格式方法
    {
        System.out.println(year+"-"+month+"-"+day);
    }
    int equaldate(int year,int month,int day,int year1,int month1,int day1){
        int count=0,temp=0;
        if(year<year1){
            temp=year;
            year=year1;
            year1=temp;
        }
        if(month<month1){
            temp=month;
            month=month1;
            month1=temp;
        }
        if(day<day1){
            temp=day;
            day=day1;
            day1=temp;
        }
        while(true){
            if(year==year1&&month==month1&&day==day1){
                return count;
            }
            day++;
            if(month1>12){
                year1++;
                month1=1;
            }
            if(day>getDaysOfMonth(year1,month1)){
                month1++;
                day=1;
            }
            else{
                count++;
            }
        }
    }
    static int[] DaysOfMonth={31,28,31,30,31,30,31,31,30,31,30,31};
     private static int getDaysOfMonth(int year,int month){
        if(judgeleapyear(year)){
            return 29;
        }
        else{
            return DaysOfMonth[month-1];
        }
    }
    private static boolean judgeleapyear(int year){
        if((year%4==0&&year%100!=0)||year%400==0){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean judgeyear(int year){
        if(year<1900||year>2100){
            return false;
        }
        else{
            return true;
        }
    }
    private static boolean judeemonth(int month){
        if(month<1||month>12){
            return false;
        }
        else{
            return true;
        }
    }
    private boolean judgedays(int day){
        if(day<1||day>getDaysOfMonth(this.year,this.month)){
            return false;
        }
        else{
            return true;
        }
    }
}
public class test0520 {
    public static void main(String[] args) {
        date today = new date(2019, 05, 21);
        today.minus(22);
        today.print();
        System.out.println("相差："+today.equaldate(2019,12,21,2020,12,01));
    }
}
