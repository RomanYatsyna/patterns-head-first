package proxy.protectionproxy;

/**
 * Центральное место в нашей службе знакомст занимает компонент Person, предназначенный
 * для чтения и записи данных кандидата.
 */
public interface PersonBean {

    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);

}