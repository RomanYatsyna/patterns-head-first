package proxy.protectionproxy;

/**
 * Класс PersonBeanImpl реализует интерфейс PersonBean.
 */
public class PersonBeanImpl implements PersonBean {
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount = 0;

    // Get-методы возвращают значения соответствующих переменных экземпляров.
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    /**
     * Метод вычисляет среднюю оценку делением суммы на количество оценок
     * ratingCount.
     */
    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) return 0;
        return (rating/ratingCount);
    }

    // Set-методы задают значения соответствующих переменных.
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * Метод увеличивает значение ratingCount и прибавляет оценку к накапливаемой
     * сумме.
     */
    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}