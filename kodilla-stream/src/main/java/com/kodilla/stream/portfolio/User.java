package com.kodilla.stream.portfolio;

public final class User {
    private final String userName;
    private final String userRealName;

    public User(final String userName, final String userRealName) {
        this.userName = userName;
        this.userRealName = userRealName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';


}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName.equals(user.userName);
    }

}
