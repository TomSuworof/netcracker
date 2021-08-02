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
