public class heshTable {
    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
        Table hashTable = new Table(7);
        hashTable.insert("rhino");
        hashTable.insert("man");
        hashTable.insert("computer");
        hashTable.insert("home");
        hashTable.insert("basket");
        hashTable.insert("Ferrari");
        hashTable.insert("nam");
        hashTable.print();

        System.out.println();
        hashTable.delete("man");
        System.out.println(       );
        hashTable.print();


    }
}

//класс, описывающий элемент таблицы
class Item{
    private String key;

    public Item(String key)
    {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
//класс, представляющий саму таблицу.
class Table{
    private Item [] table;//массив для элементов(сама хештаблица)
    private int size;
    private Item notitem;

    public Table(int size){
        this.size = size;
        this.table = new Item[size];
        notitem = new Item("**");
    }

    public void add( Item s){
        int count =0;
        if(count<=size)
            table[count] = s;
        count++;

    }

    //вывод на экран
    public void print() {
        for(int i = 0; i < size; i++) {
            if (table[i] != null)
                System.out.println(i + " " + table[i].getKey());
            else
                System.out.println(i + " **");
        }
    }
    //Хешфункция 1
    private int hash(String key) {
        int hash = 0;
        //методом Горнера. В конечный результат вычисления адреса вносят свою лепту все символы ключа.
        // Функция charAt() вернет целочисленное значение, представляющее символ.
        // Мы затем умножим его на простое число, которое будет больше, чем значение, полученное для любого символа.
        // Наконец, вычисляем остаток от деления(оператор %).
        for (int i = 0; i < key.length(); i++)
            hash = (31 * hash + key.charAt(i)) % size;

        return hash;
    }
    //Хешфункция 2
    //возвращаемое значение больше 0 и меньше размера массива
    //шаг смещения
    private int hash2(String key) {
        int hash =0;
        for (int i = 0; i < key.length(); i++)
            hash = 5 - (31 * hash + key.charAt(i)) % 5;
        return hash;
    }

    //вставка
    public void insert(String key){
        Item item = new Item(key);

//хеширование ключа
        int hashVal = hash(key);
        int hashval2 = hash2(key);
//Пока не будет найдена пустая ячейка или удаленный элемент(обозначенный " ")
        try {
            while (table[hashVal] != null && table[hashVal].getKey() != "**") {
                hashVal = (hashVal + hashval2) % size;
            }
        } catch (Exception ex){
            System.out.println( ex.toString());

        }
        table[hashVal] = item;
    }

    //Поиск
    public Item find(String key){
        //хеширование ключа
        int hashVal = hash(key);
        int hashval2 = hash2(key);

        while (table[hashVal]!=null){
            if(table[hashVal].getKey()==key){//Если ключ найден
                return table[hashVal];//возвращаем его
            }
            hashVal = (hashVal + hashval2) % size;
        }
        return null;//если не найден не возвращаем
    }

    //Удаление
    public void delete(String key){
        //хеширование ключа
        int hashVal = hash(key);
        int hashval2 = hash2(key);

        while (table[hashVal]!=null){
            if(table[hashVal].getKey()==key){
                table[hashVal]=notitem;
                System.out.println("Удалено");
            }
            hashVal = (hashVal + hashval2) % size;
        }
    }


}
