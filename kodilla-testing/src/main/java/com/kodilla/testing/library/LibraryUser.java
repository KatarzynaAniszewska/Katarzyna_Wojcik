package com.kodilla.testing.library;

public class LibraryUser {
    String firstName;
    String lastname;
    String peselId;

    public LibraryUser(String firstName, String lastname, String peselId) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", peselId='" + peselId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!lastname.equals(that.lastname)) return false;
        return peselId.equals(that.peselId);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + peselId.hashCode();
        return result;
    }
}
