# Zoo manager

## Homework from lecture 7 (19.07.2021)

### Задание:
Реализуем зоопарк, животные могут прибывать и убывать из зоопарка.
Так же ведем журнал учета всех вновь прибывших и тех кто убыл
ввод данных осуществляется с консоли
инициализироваться зоопарк должен сам, по умолчанию свободны по одной клетке для животных каждого типа

* Нужно реализовать Животных [Animal](model/Animal.java) всех типов, те что описаны в [Species](model/Species.java)
* Нужно реализовать Клетки для животных, интерфейс для клетки [Cage](model/Cage.java)
* Нужно реализовать Условия для клетки [Condition](model/Condition.java), кто в ней может жить, одна клетка подходит только одному виду животного
* Нужно реализовать Зоопарк [Zoo](Zoo.java), читайте описание в java doc у интерфейса
* Нужно реализовать класс, который будет ждать ввода с консоли и выполнять соответствующую операцию
  Типы операции:
  check-in <Вид Животного> <Имя Животного> Выход: сообщение приняли или нет Пример check-in Leon Leo  
  check-out <Имя Животного> Выход: сообщение выселяли или нет Пример: check-out Leo
  log Выход все изменения на текущий момент  
  Ввод команды заканчивается \n (Enter)  
  В случае неправильно сформулированной команды, нужно ругаться и просить ввести повторно

#### Замечания:
* Parser command лучше делать отдельным классом.
* Создание логов лучше поручить отдельному классу.
* Приветствуется использования шаблонов builder и Factory.
* Перед реализацией прочитайте java doc для интерфейсов

### Выполнение:

Тестирование команд:

```
Welcome to Zoo Manager
> check-in lion leo
Welcome to the family, LION leo
> check-in giraffe tally
Welcome to the family, GIRAFFE tally
> log
InhibitionLog{checkInDate=Wed Jul 21 09:52:15 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='leo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:25 MSK 2021, checkOutDate=null, animalSpecies=GIRAFFE, animalName='tally'}
> check-in penguin lolo
Welcome to the family, PENGUIN lolo
> check-in penguin pepe
Sorry, we do not have place for PENGUIN pepe
> check-in squirrel chip
Welcome to the family, SQUIRREL chip
> log
InhibitionLog{checkInDate=Wed Jul 21 09:52:15 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='leo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:25 MSK 2021, checkOutDate=null, animalSpecies=GIRAFFE, animalName='tally'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:34 MSK 2021, checkOutDate=null, animalSpecies=PENGUIN, animalName='lolo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:58 MSK 2021, checkOutDate=null, animalSpecies=SQUIRREL, animalName='chip'}
> check-out lolo
Searching through our pets...
Bye, PENGUIN lolo
> check-out pepe
Searching through our pets...
We do not have pepe
> check-out tally
Searching through our pets...
Bye, GIRAFFE tally
> check-in giraffe melman
Welcome to the family, GIRAFFE melman
> check-out leo
Searching through our pets...
Bye, LION leo
> check-in lion alex
Welcome to the family, LION alex
> log
InhibitionLog{checkInDate=Wed Jul 21 09:52:15 MSK 2021, checkOutDate=Wed Jul 21 09:54:04 MSK 2021, animalSpecies=LION, animalName='leo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:25 MSK 2021, checkOutDate=Wed Jul 21 09:53:23 MSK 2021, animalSpecies=GIRAFFE, animalName='tally'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:34 MSK 2021, checkOutDate=Wed Jul 21 09:53:08 MSK 2021, animalSpecies=PENGUIN, animalName='lolo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:58 MSK 2021, checkOutDate=null, animalSpecies=SQUIRREL, animalName='chip'}
InhibitionLog{checkInDate=Wed Jul 21 09:53:56 MSK 2021, checkOutDate=null, animalSpecies=GIRAFFE, animalName='melman'}
InhibitionLog{checkInDate=Wed Jul 21 09:54:12 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='alex'}
> check-out chip
Searching through our pets...
Bye, SQUIRREL chip
> check-out melman
Searching through our pets...
Bye, GIRAFFE melman
> check-out gloria
Searching through our pets...
We do not have gloria
> check-inout lion bonifacio
I do not know this command. Try again
> check-out alex
Searching through our pets...
Bye, LION alex
> log
InhibitionLog{checkInDate=Wed Jul 21 09:52:15 MSK 2021, checkOutDate=Wed Jul 21 09:54:04 MSK 2021, animalSpecies=LION, animalName='leo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:25 MSK 2021, checkOutDate=Wed Jul 21 09:53:23 MSK 2021, animalSpecies=GIRAFFE, animalName='tally'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:34 MSK 2021, checkOutDate=Wed Jul 21 09:53:08 MSK 2021, animalSpecies=PENGUIN, animalName='lolo'}
InhibitionLog{checkInDate=Wed Jul 21 09:52:58 MSK 2021, checkOutDate=Wed Jul 21 09:54:30 MSK 2021, animalSpecies=SQUIRREL, animalName='chip'}
InhibitionLog{checkInDate=Wed Jul 21 09:53:56 MSK 2021, checkOutDate=Wed Jul 21 09:54:45 MSK 2021, animalSpecies=GIRAFFE, animalName='melman'}
InhibitionLog{checkInDate=Wed Jul 21 09:54:12 MSK 2021, checkOutDate=Wed Jul 21 09:55:48 MSK 2021, animalSpecies=LION, animalName='alex'}
> exit
Exiting...
```

Пример с 2 клетками для львов:

```
Welcome to Zoo Manager
> check-in lion leo
Welcome to the family, LION leo
> check-in lion king
Welcome to the family, LION king
> log
InhibitionLog{checkInDate=Wed Jul 21 10:06:12 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='leo'}
InhibitionLog{checkInDate=Wed Jul 21 10:06:20 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='king'}
> check-in lion alex
Sorry, we do not have place for LION alex
> check-out leo
Searching through our pets...
Bye, LION leo
> check-out king
Searching through our pets...
Bye, LION king
> check-out alex
Searching through our pets...
We do not have alex
> log
InhibitionLog{checkInDate=Wed Jul 21 10:06:12 MSK 2021, checkOutDate=Wed Jul 21 10:06:39 MSK 2021, animalSpecies=LION, animalName='leo'}
InhibitionLog{checkInDate=Wed Jul 21 10:06:20 MSK 2021, checkOutDate=Wed Jul 21 10:06:45 MSK 2021, animalSpecies=LION, animalName='king'}
> exit
Exiting...
```

P.S.: задаётся с помощью ZooBuilder. См. комментарии в [Main](https://github.com/TomSuworof/netcracker/blob/a29cd3b9784e7827dd2311797a9a40013ef33abe/src/homeworks/hwFromLecture7/Main.java#L20)