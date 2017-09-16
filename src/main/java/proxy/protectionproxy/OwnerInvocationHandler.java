package proxy.protectionproxy;

import java.lang.reflect.*;

/**
 * Реализация обработчика. Все обработчики реализуют интерфейс InvocationHandler.
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    /**
     * Передаем реальный объект в конструкторе и сохраняем ссылку на него.
     */
    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    /**
     * При каждом вызове метода заместителя, вызывается метод invoke().
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException {

        try {
            // Если вызван get-метод, вызов передается реальному объекту.
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            // Вызов setHotOrNotRating() блокируется выдачей исключения.
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException();
            // Вызов других set-методов владельцу разрешен.
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // При вызове любого другого метода просто возвращаем null, во избежание рисков.
        return null;
    }
}