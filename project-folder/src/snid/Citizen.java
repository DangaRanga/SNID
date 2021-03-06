package snid;

import java.util.ArrayList;

/**
 * @author Jason Gayle
 * @version 1.0
 */
public class Citizen extends Person implements Comparable<Citizen> {
    private Name name;
    private Address address;
    private ArrayList<CivicDoc> papers;

    /**
     * Constructor to initialise the attributes of a citizen
     * 
     * @param gender      a character representing a citizen's gender
     * @param yearOfBirth an integer representing an citizen's year of birth
     * @param firstName   a String representing a citizen's first name
     * @param middleName  a String representing a citizen's middle name
     * @param lastName    a String representing a citizen's last name
     */
    public Citizen(char gender, int yearOfBirth, String firstName, String middleName, String lastName) {

        super(gender, yearOfBirth);
        super.setLifeStatus(0);
        name = new Name(firstName, middleName, lastName);
        papers = new ArrayList<CivicDoc>();
    }

    public Citizen(String id, String firstName, String middleName, String lastName, char gender, int yearOfBirth,
            String lifeStatus, String addressOne, String addressTwo, String addressThree, String addressFour,
            String addressFive, String motherId, String fatherId) {
        super(gender, yearOfBirth);
        if (lifeStatus.equals("Alive")) {
            super.setLifeStatus(0);
        } else if (lifeStatus.equals("Deceased")) {
            super.setLifeStatus(1);
        }
        setAddress(new Address(
                addressOne + "|" + addressTwo + "|" + addressThree + "|" + addressFour + "|" + addressFive));
        name = new Name(firstName, middleName, lastName);
        papers = new ArrayList<CivicDoc>();
        super.setId(id);
    }

    /**
     * Accessor method to get the ID of a Citizen
     * 
     * @return A String representing the Citizen's ID number
     */
    public String getId() {
        return super.getId();
    }

    /**
     * Mutator method to change a Citizen's last name
     * 
     * @param newLastName A string representing new last name to be set
     */
    public void changeLastName(String newLastName) {
        name.setLastName(newLastName);
    }

    /**
     * Setter method to set the address of a Citizen
     * 
     * @param citizenAddress The Address of the Citizen to be set
     */
    public void setAddress(Address citizenAddress) {
        address = citizenAddress;
    }

    /**
     * Accessor method to retrieve a Citizen's address
     * 
     * @return The Address of a Citizen
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Comparable method
     * 
     * @return An integer representing how one citizen's ID comapres to another's
     */
    public int compareTo(Citizen other) {
        Integer id1 = Integer.parseInt(this.getId());
        Integer id2 = Integer.parseInt(other.getId());
        return id1.compareTo(id2);
    }

    /**
     * Accessor method to get the name of a Citizen
     * 
     * @return A string representing a Citizen's name
     */
    public String getName() {
        return name.getLastName().toUpperCase() + ", " + name.getFirstName() + " " + name.getMiddleName().charAt(0)
                + ".";
    }

    public Name getNameObj() {
        return name;
    }

    /**
     * Method to add a civic paper to a citizen
     * 
     * @param paper The civic doc to be added to a citizen's list of papers
     */
    public void addCivicPaper(CivicDoc paper) {
        papers.add(paper);
    }

    /**
     * Method to get the Death certificate from a Citizen
     * @return The desired document if its found, and null if the 
     * document does not exist
     */
    public DeathCertificate getDeathDoc() {
        for (CivicDoc doc : papers) {
            if (doc.getRefNo().charAt(0) == 'D') {
                return (DeathCertificate) doc;
            }
        }
        return null;
    }
    /**
     * Method to get the Marriage certificate from a Citizen
     * @return The desired document if its found, and null if the 
     * document does not exist
     */
    public MarriageCertificate getMarriageDoc(){
        for(CivicDoc doc: papers){
            if (doc.getRefNo().charAt(0) == 'M'){
                return (MarriageCertificate) doc;
            }
        }
        return null;
    }
}