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

Поддерживаемые команды:
* ```check-in <species> <name>```
* ```check-out <name>```
* ```log```
* ```exit```

Поддерживаемые виды животных:
* Lion
* Giraffe
* Penguin
* Squirrel

Тестирование команд:

```
Welcome to Zoo Manager
> check-in lion leo
Welcome to the family, lion Leo
> CHECK-IN GIRAFFE TALLY
Welcome to the family, giraffe Tally
> cHeCk-In pEngUin lolo
Welcome to the family, penguin Lolo
> check-in squirrel chip
Welcome to the family, squirrel Chip
> check-in penguin pepe
Sorry, we do not have place for penguin Pepe
> check-in hippopotamus gloria
We can not have this kind of animal
> log
InhibitionLog{checkInDate=Thu Jul 22 11:29:31 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='Leo'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:44 MSK 2021, checkOutDate=null, animalSpecies=GIRAFFE, animalName='Tally'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:57 MSK 2021, checkOutDate=null, animalSpecies=PENGUIN, animalName='Lolo'}
InhibitionLog{checkInDate=Thu Jul 22 11:30:16 MSK 2021, checkOutDate=null, animalSpecies=SQUIRREL, animalName='Chip'}
> check-out leo
Searching through our pets...
Bye, lion Leo
> check-out giraffe tally
Searching through our pets...
We do not have giraffe tally
> check-out tally
Searching through our pets...
Bye, giraffe Tally
> check-out lolo
Searching through our pets...
Bye, penguin Lolo
> check-out pepe
Searching through our pets...
We do not have pepe
> check-out chip
Searching through our pets...
Bye, squirrel Chip
> check-inout lion bonifacio
I do not know this command. Try again
> log
InhibitionLog{checkInDate=Thu Jul 22 11:29:31 MSK 2021, checkOutDate=Thu Jul 22 11:30:58 MSK 2021, animalSpecies=LION, animalName='Leo'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:44 MSK 2021, checkOutDate=Thu Jul 22 11:32:26 MSK 2021, animalSpecies=GIRAFFE, animalName='Tally'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:57 MSK 2021, checkOutDate=Thu Jul 22 11:32:40 MSK 2021, animalSpecies=PENGUIN, animalName='Lolo'}
InhibitionLog{checkInDate=Thu Jul 22 11:30:16 MSK 2021, checkOutDate=Thu Jul 22 11:32:50 MSK 2021, animalSpecies=SQUIRREL, animalName='Chip'}
> check-in lion alex
Welcome to the family, lion Alex
> check-out lion alex
Searching through our pets...
We do not have lion alex
> log
InhibitionLog{checkInDate=Thu Jul 22 11:29:31 MSK 2021, checkOutDate=Thu Jul 22 11:30:58 MSK 2021, animalSpecies=LION, animalName='Leo'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:44 MSK 2021, checkOutDate=Thu Jul 22 11:32:26 MSK 2021, animalSpecies=GIRAFFE, animalName='Tally'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:57 MSK 2021, checkOutDate=Thu Jul 22 11:32:40 MSK 2021, animalSpecies=PENGUIN, animalName='Lolo'}
InhibitionLog{checkInDate=Thu Jul 22 11:30:16 MSK 2021, checkOutDate=Thu Jul 22 11:32:50 MSK 2021, animalSpecies=SQUIRREL, animalName='Chip'}
InhibitionLog{checkInDate=Thu Jul 22 11:33:15 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='Alex'}
> check-out alex
Searching through our pets...
Bye, lion Alex
> log all
I do not know this command. Try again
> log
InhibitionLog{checkInDate=Thu Jul 22 11:29:31 MSK 2021, checkOutDate=Thu Jul 22 11:30:58 MSK 2021, animalSpecies=LION, animalName='Leo'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:44 MSK 2021, checkOutDate=Thu Jul 22 11:32:26 MSK 2021, animalSpecies=GIRAFFE, animalName='Tally'}
InhibitionLog{checkInDate=Thu Jul 22 11:29:57 MSK 2021, checkOutDate=Thu Jul 22 11:32:40 MSK 2021, animalSpecies=PENGUIN, animalName='Lolo'}
InhibitionLog{checkInDate=Thu Jul 22 11:30:16 MSK 2021, checkOutDate=Thu Jul 22 11:32:50 MSK 2021, animalSpecies=SQUIRREL, animalName='Chip'}
InhibitionLog{checkInDate=Thu Jul 22 11:33:15 MSK 2021, checkOutDate=Thu Jul 22 11:34:39 MSK 2021, animalSpecies=LION, animalName='Alex'}
> exit now
I do not know this command. Try again
> exit
Exiting...
```

Пример с 2 клетками для львов:

```
Welcome to Zoo Manager
> check-in lion leo
Welcome to the family, lion Leo
> check-in lion alex
Welcome to the family, lion Alex
> log
InhibitionLog{checkInDate=Thu Jul 22 11:37:13 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='Leo'}
InhibitionLog{checkInDate=Thu Jul 22 11:37:20 MSK 2021, checkOutDate=null, animalSpecies=LION, animalName='Alex'}
> check-out alex
Searching through our pets...
Bye, lion Alex
> check-out leo
Searching through our pets...
Bye, lion Leo
> log
InhibitionLog{checkInDate=Thu Jul 22 11:37:13 MSK 2021, checkOutDate=Thu Jul 22 11:37:37 MSK 2021, animalSpecies=LION, animalName='Leo'}
InhibitionLog{checkInDate=Thu Jul 22 11:37:20 MSK 2021, checkOutDate=Thu Jul 22 11:37:31 MSK 2021, animalSpecies=LION, animalName='Alex'}
> exit
Exiting...
```

P.S.: задаётся с помощью ZooBuilder. См. комментарии в [Main](https://github.com/TomSuworof/netcracker/blob/a29cd3b9784e7827dd2311797a9a40013ef33abe/src/homeworks/hwFromLecture7/Main.java#L20)