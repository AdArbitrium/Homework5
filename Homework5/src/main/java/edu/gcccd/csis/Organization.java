package edu.gcccd.csis;

public class Organization {

    private String organization;
    private static int googleEmployee = 0;
    private static int microsoftEmployee = 0;

    public Organization(String o){
        if (o != null) {
            this.organization = o;
        }
        else organization = "";
    }

    public String getOrganization(){
            return organization;
    }

    public void setOrganization(String o){
        organization = o;
    }

    public static void increaseGoogleEmp(){
        googleEmployee++;
    }

    public static void decreaseGoogleEmp(){
        googleEmployee--;
    }

    public static void increaseMicrosoftEmp(){
        microsoftEmployee++;
    }

    public static void decreaseMicrosoftEmp(){
        microsoftEmployee--;
    }

    public int getNumOfEmployee(){
        if(organization.equalsIgnoreCase("google") || organization.equalsIgnoreCase("microsoft")) {
            return organization.equalsIgnoreCase("google") ? googleEmployee : microsoftEmployee;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if ( o instanceof  Organization){
            return organization.equalsIgnoreCase(o.toString()) ? true : false;
        }

        return false;
    }

    @Override
    public String toString(){
        return this.organization;
    }

}
