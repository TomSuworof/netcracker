# Zoo manager

## Homework from lecture 7 (19.07.2021)

### Задание:
Реализуем зоопарк, животные могут прибывать и убывать из зоопарка. Так же ведем журнал учета всех вновь прибывших и тех
кто убыл ввод данных осуществляется с консоли инициализироваться зоопарк должен сам, по умолчанию свободны по одной 
клетке для животных каждого типа

* Нужно реализовать Животных [Animal](model/Animal.java) всех типов, те что описаны в [Species](model/Species.java)
* Нужно реализовать Клетки для животных, интерфейс для клетки [Cage](model/Cage.java)
* Нужно реализовать Условия для клетки [Condition](model/Condition.java), кто в ней может жить, одна клетка подходит 
только одному виду животного
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
Success
> check-in penguin leo
We already have this animal
> CHECK-IN GIRAFFE TALLY
Success
> cHeCk-In penguin lOlO
Success
> check-in squirrel chip
Success
> check-in penguin pepe
Sorry, we do not have place for this animal
> check-in hippopotamus gloria
We can not have this kind of animal
> log
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:48:35 MSK 2021, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:48:51 MSK 2021, animal=giraffe Tally}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:49:10 MSK 2021, animal=penguin Lolo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:49:18 MSK 2021, animal=squirrel Chip}
Success
> check-out leo
Success
> check-out giraffe tally
We do not have this animal
> check-out tally
Success
> check-out lolo
Success
> check-out pepe
We do not have this animal
> check-out pepe
We do not have this animal
> check-out chip
Success
> check-inout bonifacio
Sorry, I do not know this command
> log
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:48:35 MSK 2021, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:48:51 MSK 2021, animal=giraffe Tally}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:49:10 MSK 2021, animal=penguin Lolo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:49:18 MSK 2021, animal=squirrel Chip}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=Sun Jul 25 17:50:01 MSK 2021, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=Sun Jul 25 17:50:19 MSK 2021, animal=lion Tally}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=Sun Jul 25 17:50:27 MSK 2021, animal=lion Lolo}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=Sun Jul 25 17:50:45 MSK 2021, animal=lion Chip}
Success
> log all
Sorry, I do not know this command
> exit
Exiting...
```

Пример с 2 клетками для львов:

```
Welcome to Zoo Manager
> check-in lion leo
Success
> check-in lion alex
Success
> log
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:58:32 MSK 2021, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:58:41 MSK 2021, animal=lion Alex}
Success
> check-out alex
Success
> check-out leo
Success
> log
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=Sun Jul 25 17:58:58 MSK 2021, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:58:32 MSK 2021, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=Sun Jul 25 17:58:52 MSK 2021, animal=lion Alex}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=Sun Jul 25 17:58:41 MSK 2021, animal=lion Alex}
Success
> exit
Exiting...
```

P.S.: задаётся с помощью ZooBuilder. См. комментарии в [Main](https://github.com/TomSuworof/netcracker/blob/a29cd3b9784e7827dd2311797a9a40013ef33abe/src/homeworks/hwFromLecture7/Main.java#L16)

### Вторая часть задания:

Реализуем зоопарк, животные могут прибывать и убывать из зоопарка. Так же ведем журнал учета всех вновь прибывших и тех
кто убыл ввод данных осуществляется с консоли инициализироваться зоопарк должен из базы данных. Состояние животных и 
клеток также необходимо сохранять в базу Схема таблиц на ваше усмотрение. Важно что бы Cage, Animal, InhibitionLog были
в базе и доставались так же из базы. После старта приложение не должно сразу выкачивать все состояние на app level, а 
работать с объектами непосредственно в момент операции (исключение кеш на клетки - ок).

### Примеры работы:

**1. Холодный старт**

Конфигурация в коде:

```
DBZoo.ZooBuilder builder = new DBZoo.ZooBuilder(connectionManager)
                    .buildCageFor(Species.LION, 1 ,50)
                    .buildCageFor(Species.GIRAFFE, 2, 100)
                    .buildCageFor(Species.PENGUIN, 3, 40)
                    .buildCageFor(Species.SQUIRREL, 4, 20);
```

Начальное состояние БД:

```
zoo=# select * from animals;
 animal_name | animal_species
-------------+----------------
(0 ёЄЁюъ)

zoo=# select * from cages;
 cage_number | cage_area | cage_condition | animal_name
-------------+-----------+----------------+-------------
(0 ёЄЁюъ)

zoo=# select * from logs;
 log_id |    event_name     |    animal     |    log_date
--------+-------------------+---------------+-----------------
(0 ёЄЁюъ)

```

Запуск. Введённые команды:

```
Welcome to Zoo Manager
> check-in lion leo
Success
> log
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:40:48.739, animal=lion Leo}
Success
> CHECK-IN PENGUIN LEO
We already have this animal
> cHeCk-in gIrAffE tALLy
Success
> check-in penguin lolo
Success
> check-in squirrel chip
Success
> check-in penguin pepe
Sorry, we do not have place for this animal
> check-in hippopotamus gloria
We can not have this kind of animal
> log
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:43.843, animal=penguin Lolo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:59.727, animal=squirrel Chip}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:31.995, animal=giraffe Tally}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:40:48.739, animal=lion Leo}
Success
> check-out leo
Success
> check-out tally
Success
> check-out lolo
Success
> check-out pepe
We do not have this animal
> check-out chip
Success
> log
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:42:39.301, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:43.843, animal=penguin Lolo}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:42:50.829, animal=lion Tally}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:43:10.939, animal=lion Chip}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:42:57.474, animal=lion Lolo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:40:48.739, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:59.727, animal=squirrel Chip}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:31.995, animal=giraffe Tally}
Success
> exit
Exiting...

```

Конечное состояние БД:
```
zoo=# select * from animals;
 animal_name | animal_species
-------------+----------------
(0 ёЄЁюъ)


zoo=# select * from cages;
 cage_number | cage_area | cage_condition | animal_name
-------------+-----------+----------------+-------------
           1 |        50 | {LION}         |
           2 |       100 | {GIRAFFE}      |
           3 |        40 | {PENGUIN}      |
           4 |        20 | {SQUIRREL}     |
(4 ёЄЁюъш)


zoo=# select * from logs;
 log_id |     event_name     |    animal     |          log_date
--------+--------------------+---------------+----------------------------
      1 | ANIMAL_CHECKED_IN  | lion Leo      | 2021-08-06 15:40:48.739+03
      2 | ANIMAL_CHECKED_IN  | giraffe Tally | 2021-08-06 15:41:31.995+03
      3 | ANIMAL_CHECKED_IN  | penguin Lolo  | 2021-08-06 15:41:43.843+03
      4 | ANIMAL_CHECKED_IN  | squirrel Chip | 2021-08-06 15:41:59.727+03
      5 | ANIMAL_CHECKED_OUT | lion Leo      | 2021-08-06 15:42:39.301+03
      6 | ANIMAL_CHECKED_OUT | lion Tally    | 2021-08-06 15:42:50.829+03
      7 | ANIMAL_CHECKED_OUT | lion Lolo     | 2021-08-06 15:42:57.474+03
      8 | ANIMAL_CHECKED_OUT | lion Chip     | 2021-08-06 15:43:10.939+03
(8 ёЄЁюъ)
```

**2. Старт с пре-конфигурацией**

Конфигурация в коде:

```
DBZoo.ZooBuilder builder = new DBZoo.ZooBuilder(connectionManager);
```

Начальное состояние базы - смотри конечное состояние базы выше

Запуск. Введённые команды:

```
Welcome to Zoo Manager
> log
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:59.727, animal=squirrel Chip}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:31.995, animal=giraffe Tally}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:43:10.939, animal=lion Chip}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:42:50.829, animal=lion Tally}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:42:57.474, animal=lion Lolo}
InhabitationLog{event=ANIMAL_CHECKED_OUT, date=2021-08-06 15:42:39.301, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:40:48.739, animal=lion Leo}
InhabitationLog{event=ANIMAL_CHECKED_IN, date=2021-08-06 15:41:43.843, animal=penguin Lolo}
Success
> check-in lion king
Success
> check-in lion alex
Sorry, we do not have place for this animal
> check-in squirrel dale
Success
> exit
Exiting...
```
Конечное состояние базы:

```
zoo=# select * from animals;
 animal_name | animal_species
-------------+----------------
 King        | LION
 Dale        | SQUIRREL
(2 ёЄЁюъш)


zoo=# select * from cages;
 cage_number | cage_area | cage_condition | animal_name
-------------+-----------+----------------+-------------
           2 |       100 | {GIRAFFE}      |
           3 |        40 | {PENGUIN}      |
           1 |        50 | {LION}         | King
           4 |        20 | {SQUIRREL}     | Dale
(4 ёЄЁюъш)


zoo=# select * from logs;
 log_id |     event_name     |    animal     |          log_date
--------+--------------------+---------------+----------------------------
      1 | ANIMAL_CHECKED_IN  | lion Leo      | 2021-08-06 15:40:48.739+03
      2 | ANIMAL_CHECKED_IN  | giraffe Tally | 2021-08-06 15:41:31.995+03
      3 | ANIMAL_CHECKED_IN  | penguin Lolo  | 2021-08-06 15:41:43.843+03
      4 | ANIMAL_CHECKED_IN  | squirrel Chip | 2021-08-06 15:41:59.727+03
      5 | ANIMAL_CHECKED_OUT | lion Leo      | 2021-08-06 15:42:39.301+03
      6 | ANIMAL_CHECKED_OUT | lion Tally    | 2021-08-06 15:42:50.829+03
      7 | ANIMAL_CHECKED_OUT | lion Lolo     | 2021-08-06 15:42:57.474+03
      8 | ANIMAL_CHECKED_OUT | lion Chip     | 2021-08-06 15:43:10.939+03
      9 | ANIMAL_CHECKED_IN  | lion King     | 2021-08-06 15:45:35.729+03
     10 | ANIMAL_CHECKED_IN  | squirrel Dale | 2021-08-06 15:45:54.458+03
(10 ёЄЁюъ)
```
