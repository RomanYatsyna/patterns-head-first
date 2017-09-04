package decorator.coffeshop;

/**
 * Реализация декоратора. Класс декоратора расширяет CondimentDecorator.
 * Чтобы в объекте Mocha хранилась ссылка на Beverage, нам понадобятся:
 * 1. Переменная для хранения ссылки.
 * 2. Способ присваивания переменной ссылки на объект. Мы будем передавать ссылку
 * при вызове конструктора
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * В описании должны содержаться не только название напитка (допустим,
     * Dark Roast), но и все дополнения, например "Dark Roast, Mocha". Таким
     * образом, мы сначала получаем описание, делегируя вызов декорируемому обхекту,
     * а затем присоединяем к нему строку ", Mocha".
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    /**
     * Теперь необходимо вычислить стоимость напитка с шоколадом. Сначала вызов
     * делегируется декорируемому объекту, а затем стоимость шоколада прибавляется к
     * результату.
     */
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
