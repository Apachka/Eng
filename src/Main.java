/**
 * Created by student on 15.10.16.
 */

import sun.net.ftp.FtpDirEntry;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Args parsel = new Parser(args).parse();

        //System.out.println(parsel.password);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        boolean l1 = thisLogin(parsel, users);
        System.out.println(l1);
        boolean p1 = thisPassword(parsel, users);
        System.out.println(p1);
        checkAuthentication(parsel, users);
        thisRole(parsel);


        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, users.get(0), "READ", "a"));//���� 1
        roles.add(new Role(2, users.get(0), "WRITE", "a.b"));//���� 1
        //����� ��� ������� 2(������ � 0) ������������� ���� ������� "EXECUTE", "a.b.c"
        roles.add(new Role(3, users.get(1), "EXECUTE", "a.b.c"));
        roles.add(new Role(4, users.get(0), "EXECUTE", "a.bc"));//���� 1
    }

    // ������������� ������� (�������) ��� ������ � ������� ������������
    //���� �� ������ � ������
    private static void checkAuthentication(Args args1, List<User> users) {
        if (thisLogin(args1, users)) {
            if (thisPassword(args1, users)) {
                System.out.println("Successfully Authentication");

            } else {
                System.out.println("Wrong password");
                System.exit(2);
            }
        } else {
            System.out.println("Unknown user");
            System.exit(1);
        }
    }

    private static void checkAuthorization(List<Role> roles, Args args1)
    {
        if( ){}

    }
/*


private static void tryAuthor(ArrayList<Role> anArrayOfRoles, Userdata userdata) {
        if (isCorrectRole(userdata)) {
            if (isCorrectResource(userdata, anArrayOfRoles)) {
                System.out.println("Successfully Author.");
            } else {
                System.out.println("Doesn't exist");
                System.exit(4);
            }
        } else {
            System.out.println("Unknown Role");
            System.exit(3);
        }
}

*/
    private static boolean thisLogin(Args args1, List<User> users) {
        for (User user : users) {
            if (user.getLogin().equals(args1.login)) {
                return true;
            }
        }
        return false;
    }

    private static boolean thisPassword(Args args1, List<User> users) {
        for (User user : users) {
            if (user.getPassword().equals(args1.password) && user.getLogin().equals(args1.login)) {
                return true;
            }
        }
        return false;
    }

    private static boolean thisRole(Args args1) {
        try {
            &&(args1.getRole());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }
/*NullPointerException � ��� ����������, ������� ��������, ��� ��������� ������������ ������� ���������.
 �.�. ����������� �� ������������, ��� ��������� ����� �������.


� IllegalArgumentException � ��������, ��� ������������ �������� ������� ������� ������������.
    �.� ����������� �����������, ��� � ����� ����� �������� ������ **, � ������������� �� �����.*/

    private static boolean thisResource(Args args1, List<Role> roles) {
        for (Role role : roles) {
            if (args1.
            ().equals(role.name) &&

                    (role.resource, args1.getResource())
                    && (args1.getLogin().equals(role
                    ) {
                return true;
            }
        }
        return false;

}

}




/*
public class Main
{
    public static void main(String ...args) {
        ArrayList <User> users = new ArrayList<>();
        //users.add(1,"John Doe", "jdoe", "sup3rpaZZ");
        //users.add(new User("John Doe"));
        users.add(("John Doe"));
        //users.add(2,"Jane Row", "jrow", "Qweqrty12");
        System.out.println("New Users: " + users);


1, "John Doe", "jdoe", "sup3rpaZZ"
2, "Jane Row", "jrow", "Qweqrty12"
�������� ������ �� ������
1, jdoe, Role.READ, "a"
2, jdoe, Role.WRITE, "a.b"
3, jrow, Role.EXECUTE, "a.b.c"
4, jdoe, Role.EXECUTE, "a.bc"

*/