package edu.gcccd.csis;

public class Employee {

    private String name;
    private String jobTitle;
    private String organization;
    private String birthday;


   public Employee(String name, String jobTitle, String organization, String birthday){
       this.name = name;
       this.jobTitle = jobTitle;
       this.organization = organization;
       if (organization.equalsIgnoreCase("google")) {
           Organization.increaseGoogleEmp();
       }
       if (organization.equalsIgnoreCase("microsoft")){
           Organization.increaseMicrosoftEmp();
       }
       this.birthday = birthday;
   }

   public String getName() {
       return name;
   }

    public String getJobTitle() {
       return jobTitle;
   }

   public String getOrganization() {
       return organization;
   }

    public String getBirthday() {
        return birthday;
    }

   public void setJobTitle(String j){
       jobTitle = j;
   }

   public  void setName(String n){
       name = n;
   }

   public void setOrganization(String o){
       if (!organization.equalsIgnoreCase(o)){
           if (organization.equalsIgnoreCase("microsoft"))
           {
               Organization.increaseGoogleEmp();
               Organization.decreaseMicrosoftEmp();
               organization = o;
           }
           if (organization.equalsIgnoreCase("google")){
               Organization.increaseMicrosoftEmp();
               Organization.decreaseGoogleEmp();
               organization = o;
           }
       }
   }

    @Override
    public boolean equals(Object o){
       if (o instanceof Employee) {
           if(organization.equals(((Employee) o).getOrganization())
                   && name.equals(((Employee) o).getName())
                   && birthday.equals(((Employee) o).getBirthday())){
               return true;
           }
       }
        return false;
    }
}
