package com.tima.inventory.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuessScreen() {
    Column(Modifier.padding(16.dp)) {
        var textFieldText by rememberSaveable { mutableStateOf("") }
        var result by rememberSaveable { mutableStateOf("") }
        val manNamesList = listOf(
            "Александр", "Саша", "Алексей", "Леша", "Андрей", "Антон", "Арсений", "Арс", "Артем", "Тёма", "Богдан", "Борис",
            "Вадим", "Валентин", "Валера", "Валерий", "Василий", "Вася", "Виктор", "Витя", "Виталий", "Виталик", "Владимир", "Влад",
            "Владислав", "Владик", "Всеволод", "Вова", "Георгий", "Жора", "Григорий", "Гриша", "Давид", "Даниил", "Даня", "Денис",
            "Ден", "Дмитрий", "Дима", "Евгений", "Женя", "Егор", "Иван", "Ваня", "Игорь", "Кирилл", "Кир", "Константин", "Костя",
            "Леонид", "Лёня", "Максим", "Макс", "Матвей", "Миша", "Михаил", "Никита", "Николай", "Коля", "Олег", "Павел", "Паша",
            "Петр", "Петя", "Роман", "Рома", "Сергей", "Сережа", "Станислав", "Стас", "Степан", "Степа", "Тимофей", "Тима",
            "Юрий", "Юра", "Ярослав", "Ярик", "Анатолий", "Толя", "Вячеслав", "Слава", "Лев", "Лео", "Марсель", "Мирон", "Мирослав",
            "Руслан", "Русик", "Тимур", "Тима", "Альберт", "Эмиль", "Артур", "Ратмир", "Глеб", "Савелий", "Сава", "Марк", "Клим",
            "Адам", "Федор", "Федя", "Геннадий", "Гена", "Рустам", "Рустик", "Эрик", "Кристофер", "Радмир", "Алан", "Роберт",
            "Роб", "Назар", "Амир", "Эльдар", "Лука", "Дамир", "Илья", "Семен", "Арсен", "Лионель", "Тарас", "Милан", "Ян",
            "Елисей", "Ренат", "Викентий", "Радик", "Давлат", "Майкл", "Рон", "Тигран", "Ждан", "Серафим", "Оскар", "Ари", "Кир",
            "Айдар", "Эмин", "Эдгар", "Муса", "Ларс", "Стивен", "Гарри", "Патрик", "Оскар", "Эд", "Дамир", "Филипп", "Филя",
            "Азамат", "Юлиан", "Ян", "Султан", "Артемий", "Артемка", "Тимофей", "Сергей", "Роман", "Арсений", "Марс", "Радмир",
            "Натан", "Альфред", "Амос", "Маркус", "Гордей", "Мирослав", "Омар", "Диего", "Том", "Тео", "Харитон", "Фадей", "Ибрагим",
            "Лео", "Рафаэль", "Бен", "Дан", "Ильяс", "Карим", "Батыр", "Бехруз", "Адиль", "Юсуф", "Самир", "Жорик", "Алик",
            "Бек", "Жасур", "Нур", "Тимур", "Салим", "Омар", "Ислам", "Айдар", "Руслан", "Женя", "Платон", "Вениамин", "Алихан",
            "Эдгар", "Вильям", "Рем", "Владимир", "Валера", "Тамерлан", "Аристарх", "Батыр", "Юлиан", "Станимир", "Генрих",
            "Густав", "Ричард", "Эрик", "Жорик", "Эльбрус", "Саид", "Тамир", "Эмин", "Амир", "Рамзан", "Женя", "Ислам", "Леон",
            "Феликс", "Джозеф", "Ильдар", "Арнольд", "Касим", "Борислав", "Глеб", "Али", "Роберт", "Борис", "Донат", "Лев",
            "Камиль", "Лавр", "Фарид", "Габриэль", "Казбек", "Эрик", "Роберт", "Жерар", "Арчи", "Владислав", "Леон", "Назар",
            "Серго", "Октай", "Макар", "Ален", "Эд", "Мир", "Илья", "Самсон", "Стефан", "Альмир", "Рафаил", "Ларри", "Габриэль",
            "Василь", "Эрнест", "Эрик", "Рафаэль", "Женя", "Арнольд", "Диего", "Мариан", "Лаврентий", "Жан", "Тигран", "Теймур",
            "Артем", "Саша", "Виктор", "Игорь", "Феликс", "Руслан", "Ибрагим", "Камиль", "Джамал", "Гриша", "Азам", "Динар",
            "Сергей", "Тамерлан", "Аркадий", "Слава", "Шамиль", "Леон", "Амир", "Муса", "Арслан", "Фарид", "Давид", "Эмиль",
            "Эрик", "Артур", "Ренат", "Лео", "Эльдар", "Глеб", "Тимур", "Денис", "Арман", "Роман", "Александр", "Семён", "Максим",
            "Ярослав", "Артём", "Тимофей", "Виталий", "Михаил", "Данил", "Пётр", "Валерий", "Илья", "Кирилл", "Семен", "Павел",
            "Евгений", "Стас", "Антон", "Олег", "Николай", "Дмитрий", "Игорь", "Марк", "Федор", "Лев", "Альберт", "Тарас"
        ).map { it.lowercase() }
        val femaleNamesList = listOf(
            "Александра", "Саша", "Алена", "Алиса", "Алла", "Алина", "Алёна", "Альбина", "Анастасия", "Настя", "Анжелика",
            "Анна", "Аня", "Анфиса", "Арина", "Валентина", "Валя", "Валерия", "Лера", "Варвара", "Варя", "Василиса", "Вика",
            "Виктория", "Виталина", "Галина", "Галя", "Дарья", "Даша", "Диана", "Ева", "Евгения", "Женя", "Екатерина", "Катя",
            "Елена", "Лена", "Елизавета", "Лиза", "Есения", "Жанна", "Зарина", "Злата", "Зоя", "Иванна", "Илона", "Инга",
            "Инна", "Ирина", "Ира", "Камилла", "Карина", "Каролина", "Кира", "Кристина", "Ксения", "Ксюша", "Лариса", "Лара",
            "Лейла", "Лидия", "Лида", "Лилия", "Лиля", "Любовь", "Люба", "Людмила", "Люда", "Майя", "Маргарита", "Рита",
            "Марина", "Мария", "Маша", "Марфа", "Марьяна", "Мелания", "Мила", "Милана", "Надежда", "Надя", "Наталья", "Наташа",
            "Нелли", "Ника", "Нина", "Оксана", "Оля", "Ольга", "Полина", "Поля", "Раиса", "Регина", "Рената", "Римма", "Рита",
            "Роза", "Светлана", "Света", "Снежана", "София", "Софья", "Соня", "Таисия", "Тая", "Тамара", "Тома", "Татьяна",
            "Таня", "Ульяна", "Фаина", "Христина", "Эвелина", "Эльвира", "Юлия", "Юля", "Яна", "Ярослава", "Сабина", "Саида",
            "Сафия", "Самира", "Лилия", "Далила", "Влада", "Эльза", "Элеонора", "Вера", "Сара", "Нонна", "Сирена", "Лейсан",
            "Малика", "Майя", "Мира", "Ника", "Олеся", "Лея", "Клара", "Феруза", "Диляра", "Фатима", "Люция", "Илона",
            "Айгуль", "Селена", "Сиенна", "Жаклин", "Аделина", "Амира", "Радмила", "Евдокия", "Альмира", "Айна", "Карима",
            "Тамина", "Талина", "Юнона", "Ида", "Лора", "Анна-Мария", "Марта", "Антонина", "Лукерья", "Гелла", "Луиза",
            "Диана", "Аделия", "Аврора", "Камалия", "Венера", "Азиза", "Сабрина", "Эвелина", "Майя", "Анна-Лиза", "Софина",
            "Мари", "Мира", "Ксения", "Снежана", "Роксана", "Мадина", "Шахназ", "Фируза", "Гуля", "Татьяна", "Малика",
            "Индира", "Соня", "Табита", "Эмилия", "Эльза", "Элина", "Симона", "Милена", "Жанна", "Радмила", "Виолетта",
            "Габриэлла", "Жозефина", "Карина", "Диана", "Марфа", "Василина", "Олеся", "Захра", "Катарина", "Нора", "Тамина",
            "Алисия", "Марина", "Мерседес", "Магдалина", "Снежана", "Эсмира", "Джанна", "Мариэтта", "Лана", "Далия", "Дина",
            "Зейнаб", "Сафина", "Нейла", "Тереза", "Тиана", "Сания", "Амели", "Джессика", "Фарида", "Сабина", "Айлин",
            "Айгуль", "Самира", "Лаура", "Эльмира", "Яна", "Алия", "Амира", "Элина", "Сафия", "Диана", "Сильвия", "Аманда",
            "Изабелла", "Марта", "Евгения", "Айза", "Сюзанна", "Тамара", "Роксана", "Мирослава", "Сюзанна", "Ксения", "Алсу",
            "Екатерина", "Снежана", "Флора", "Вивиан", "Альфия", "Амалия", "Диля", "Лейла", "Ирма", "Лиза", "Серена", "Айяна",
            "Фарида", "Тина", "Гульнара", "Дариана", "Жаннет", "Мириам", "Иванна", "Нелли", "Алсу", "Сания", "Гюзель", "Алёна",
            "Галина", "Дарина", "Тамара", "Лола", "Юлиана", "Мия", "Тахмина", "Рафида", "Анжела", "Эльмира", "Розалия",
            "Алия", "Женя", "Зоя", "Алёна", "Юлия", "Валентина", "Натали", "Сабина", "Дания", "Каролина", "Дана", "Малика",
            "Амелия", "Таня", "Олеся", "Зара", "Элина", "Евгения", "Вероника", "Татьяна", "Лада", "Илона", "Оксана", "Маргарита",
            "Эмма", "Римма", "Камила", "Зинаида", "Кристина", "Алёна", "Ксения", "Аида", "Руфина", "Елизавета", "Жанна", "София"
        ).map { it.lowercase() }
        val carList = listOf(
            "Toyota", "Honda", "BMW", "Mercedes-Benz", "Audi", "Chevrolet", "Ford", "Nissan", "Volkswagen", "Porsche",
            "Lexus", "Hyundai", "Kia", "Mazda", "Subaru", "Jaguar", "Land Rover", "Mini", "Fiat", "Ferrari",
            "Lamborghini", "Aston Martin", "Bentley", "Rolls-Royce", "Bugatti", "Maserati", "Alfa Romeo", "Tesla", "Rivian", "Lucid Motors",
            "Cadillac", "Chrysler", "Dodge", "GMC", "Ram", "Jeep", "Peugeot", "Renault", "Citroen", "Opel",
            "Skoda", "Volkswagen", "Seat", "Suzuki", "Mitsubishi", "Isuzu", "Hummer", "Chery", "Geely", "BYD",
            "Great Wall", "Fisker", "Polestar", "Nissan", "Toyota", "Ford", "Chevrolet", "Honda", "Hyundai", "Mazda",
            "Buick", "Lincoln", "Buick", "Acura", "Infiniti", "Genesis", "Lincoln", "Chrysler", "Ram", "Buick",
            "Abarth", "Dacia", "Zotye", "GAC", "Peugeot", "Ferrari", "Pagani", "Koenigsegg", "Spyker", "Vauxhall",
            "Tesla", "Volvo", "Saab", "Lotus", "Morgan", "Mitsubishi", "Honda", "Isuzu", "Nissan", "Mazda",
            "Lancia", "Lada", "Chevrolet", "Toyota", "Ford", "BMW", "Porsche", "Audi", "Volkswagen", "Peugeot",
            "Honda", "BMW", "Mercedes-Benz", "Lexus", "Audi", "Cadillac", "Lincoln", "Chrysler", "Nissan", "Kia",
            "Hyundai", "Jeep", "Toyota", "Chevrolet", "Ford", "Volkswagen", "Mazda", "BMW", "Renault", "Volvo",
            "Bugatti", "Rolls-Royce", "Bentley", "Ferrari", "Aston Martin", "Maserati", "Lamborghini", "Porsche", "Jaguar", "McLaren",
            "Alfa Romeo", "Dodge", "Chrysler", "Ram", "Buick", "Subaru", "Tesla", "Cadillac", "Peugeot", "Fisker",
            "Rivian", "Polestar", "Mitsubishi", "Ford", "Chrysler", "Jeep", "Toyota", "BMW", "Chevrolet", "Nissan",
            "Toyota", "Hyundai", "Kia", "Ford", "Chevrolet", "Honda", "BMW", "Mazda", "Tesla", "Volkswagen",
            "Honda", "Nissan", "Toyota", "Ford", "Chevrolet", "Hyundai", "BMW", "Lexus", "Mazda", "Subaru",
            "Buick", "Chrysler", "Ram", "Fiat", "Jaguar", "Land Rover", "Mitsubishi", "Peugeot", "Renault", "Nissan",
            "Opel", "Audi", "BMW", "Volkswagen", "Porsche", "Jaguar", "Land Rover", "Lexus", "Cadillac", "Chevrolet",
            "Ford", "Toyota", "Hyundai", "BMW", "Audi", "Mercedes-Benz", "Porsche", "Nissan", "Volkswagen", "Tesla",
            "Chevrolet", "Cadillac", "Buick", "Jeep", "Ram", "Chrysler", "Mitsubishi", "Subaru", "Mazda", "Kia",
            "Honda", "Toyota", "Nissan", "BMW", "Audi", "Volkswagen", "Porsche", "Ford", "Chevrolet", "Jaguar",
            "Rolls-Royce", "Lamborghini", "Ferrari", "Maserati", "Aston Martin", "Porsche", "McLaren", "Bugatti", "Koenigsegg", "Pagani",
            "Tesla", "Rivian", "Lucid Motors", "Fisker", "Polestar", "BMW", "Mercedes-Benz", "Audi", "Lexus", "Hyundai"
        ).map { it.lowercase() }
        val brandList = listOf(
            "Nike", "Adidas", "Puma", "Reebok", "Under Armour", "New Balance", "Converse", "Vans", "Levi's", "Wrangler",
            "Calvin Klein", "Tommy Hilfiger", "Ralph Lauren", "Gucci", "Prada", "Louis Vuitton", "Chanel", "Hermès", "Burberry", "Fendi",
            "Dolce & Gabbana", "Versace", "Armani", "Balenciaga", "BOSS", "Miu Miu", "Saint Laurent", "Celine", "Chloé", "Valentino",
            "H&M", "Zara", "Uniqlo", "Mango", "Gap", "Old Navy", "American Eagle", "Abercrombie & Fitch", "Urban Outfitters", "Aerie",
            "Lululemon", "Athleta", "Reebok", "Under Armour", "Patagonia", "North Face", "Columbia", "Timberland", "Carhartt", "Dickies",
            "Fossil", "Michael Kors", "Kate Spade", "Coach", "Tory Burch", "Marc Jacobs", "Calvin Klein", "Donna Karan", "Tom Ford", "Kate Spade",
            "BOSS", "Diesel", "Pepe Jeans", "Levi's", "Wrangler", "Dockers", "Guess", "True Religion", "Seven for All Mankind", "Lucky Brand",
            "Esprit", "Superdry", "Lee", "Fruit of the Loom", "Hollister", "Aeropostale", "Abercrombie", "American Apparel", "Urban Outfitters",
            "Lacoste", "Fred Perry", "Ben Sherman", "Gant", "J.Crew", "Banana Republic", "Saks Fifth Avenue", "Nordstrom", "Macy's", "Bloomingdale's",
            "Lululemon", "Nike", "Adidas", "Puma", "Reebok", "Fila", "New Balance", "Vans", "Converse", "Toms",
            "Dr. Martens", "Timberland", "Skechers", "Clarks", "UGG", "Steve Madden", "Michael Kors", "Coach", "Kate Spade", "Tory Burch",
            "Sorel", "Columbia Sportswear", "Patagonia", "North Face", "Arc'teryx", "Prada", "Gucci", "Hermès", "Chanel", "Louis Vuitton",
            "Valentino", "Bally", "Aldo", "Jimmy Choo", "Manolo Blahnik", "Christian Louboutin", "Dr. Martens", "Chloe", "Marc Jacobs", "Boden",
            "Reiss", "Moncler", "Canada Goose", "Balmain", "Saint Laurent", "Alexander McQueen", "Fendi", "Miu Miu", "Sandro", "Equipment",
            "Aritzia", "Anthropologie", "Free People", "Madewell", "Everlane", "Revolve", "ASOS", "Boohoo", "Shein", "PrettyLittleThing",
            "Romwe", "Forever 21", "Charlotte Russe", "Express", "Lulus", "ModCloth", "Nasty Gal", "Pacsun", "Billabong", "Quiksilver",
            "Hurley", "Volcom", "Rip Curl", "Roxy", "O'Neill", "Element", "Billabong", "Vans", "Toms", "Sperry Top-Sider",
            "Nike", "Adidas", "Puma", "Champion", "New Balance", "Fila", "Converse", "Vans", "Levi's", "Wrangler", "Wrangler",
            "Lacoste", "Hugo Boss", "Tommy Hilfiger", "Ralph Lauren", "Calvin Klein", "DKNY", "Ted Baker", "AllSaints", "Banana Republic", "J.Crew"
        ).map { it.lowercase() }
        val animalList = listOf(
            "Лев", "Тигр", "Слон", "Жираф", "Зебра", "Обезьяна", "Кенгуру", "Панда", "Коала", "Пингвин",
        "Медведь", "Волк", "Лисица", "Олень", "Кролик", "Белка", "Еж", "Лошадь", "Осел", "Корова",
        "Коза", "Овца", "Свинья", "Курица", "Утка", "Индейка", "Петух", "Рыба", "Акула", "Кит",
        "Дельфин", "Тюлень", "Октопус", "Звезда морская", "Черепаха", "Ящерица", "Змея", "Лягушка", "Жаба", "Летучая мышь",
        "Орёл", "Ястреб", "Сокол", "Сова", "Попугай", "Воробей", "Ворон", "Сорока", "Павлин", "Фламинго",
        "Ласточка", "Дятел", "Голубь", "Чайка", "Пеликаны", "Аист", "Цапля", "Гусь", "Кондор", "Стервятник",
        "Гепард", "Леопард", "Ягуар", "Пума", "Гиена", "Носорог", "Бегемот", "Бизон", "Кафрский антилопа", "Камел",
        "Лама", "Альпака", "Страус", "Эму", "Валлиби", "Вомбат", "Платипус", "Тасманийский дьявол", "Броненосец",
        "Ленивец", "Муравьед", "Бобёр", "Выдра", "Крот", "Жук", "Божья коровка", "Стрекоза", "Бабочка", "Пчела",
        "Мурашки", "Гусеница", "Кузнечик", "Крикет", "Паук", "Скорпион", "Миллиметровка", "Центопед", "Кит", "Дельфин",
        "Морская свинья", "Манатий", "Нарвал", "Белуга", "Сейвал", "Морской котик", "Кит", "Пельмень", "Морской конёк", "Кораллы",
        "Медуза", "Кальмар", "Моллюск", "Устрица", "Мидия", "Рак", "Краб", "Креветка", "Шримп", "Улитка",
        "Крот", "Крыса", "Мышь", "Хомяк", "Гербиль", "Кролик", "Морская свинка", "Шиншилла", "Гуинея", "Фретка",
        "Койот", "Шакал", "Тасманийский тигр", "Фосса", "Гепард", "Лев", "Пума", "Пантера", "Сервал", "Рысь",
        "Кайман", "Аллигатор", "Крокодил", "Комодский дракон", "Гила", "Геккон", "Хамелеон", "Игуана", "Сквинки", "Монитор",
        "Лягушка", "Жаба", "Саламандра", "Тритон", "Аксолотль", "Лебедь", "Утка", "Гусь", "Павлин", "Голубь",
        "Квак", "Тасманийский дьявол", "Вомбат", "Платипус", "Эхидна", "Квокка", "Ибекс", "Шамой", "Козел", "Антилопа",
        "Козел", "Тигр", "Ягуар", "Кошка", "Дог", "Манчестер", "Русская гончая", "Грейт Дейн", "Терьер", "Йоркшир",
        "Пудель", "Далматинец", "Сибирский хаски", "Чихуахуа", "Такса", "Ши-тцу", "Пудель", "Бультерьер", "Ротвейлер", "Шнауцер",
        "Кавалер кинг-чарльз", "Спаниель", "Кокер", "Сенбернар", "Питбулл", "Английский булли", "Французский бульдог", "Австралийская овчарка", "Коли", "Корги",
        "Кошка", "Коты", "Тигр", "Леопард", "Дикая кошка", "Бенгал", "Мейн-кун", "Рагдолл", "Сфинкс", "Персидская кошка"
        ).map { it.lowercase() }
        val appsList = listOf(
            "WhatsApp", "Facebook", "Instagram", "Twitter", "TikTok", "Snapchat", "Telegram", "LinkedIn", "YouTube", "Spotify",
            "Netflix", "Amazon", "Google Maps", "Uber", "Airbnb", "Zoom", "Skype", "Viber", "Reddit", "Pinterest",
            "Slack", "Microsoft Teams", "Discord", "Trello", "Evernote", "Google Drive", "Dropbox", "OneDrive", "iCloud", "Waze",
            "Google Photos", "Apple Music", "Shazam", "SoundCloud", "Google Chrome", "Safari", "Firefox", "Opera", "Brave", "Microsoft Edge",
            "Gmail", "Outlook", "Yahoo Mail", "ProtonMail", "Telegram", "WeChat", "Signal", "Weibo", "Clubhouse", "VKontakte",
            "TikTok", "Viber", "Bumble", "Tinder", "Hinge", "OkCupid", "Grindr", "eBay", "Etsy", "AliExpress",
            "Spotify", "Pandora", "Apple Music", "Amazon Music", "Deezer", "Napster", "iHeartRadio", "Google Podcasts", "Pocket Casts", "Stitcher",
            "Google Keep", "Notion", "Simplenote", "Todoist", "Any.do", "Asana", "Monday.com", "Basecamp", "ClickUp", "Jira",
            "GitHub", "GitLab", "Bitbucket", "Visual Studio Code", "Xcode", "Android Studio", "IntelliJ IDEA", "Postman", "Slack", "Zoom",
            "Canva", "Adobe Photoshop Express", "Adobe Lightroom", "PicsArt", "Snapseed", "VSCO", "InShot", "Pixlr", "Prisma", "Facetune",
            "Netflix", "Hulu", "Disney+", "Amazon Prime Video", "HBO Max", "Apple TV+", "Peacock", "YouTube TV", "Tubi", "Pluto TV",
            "Khan Academy", "Duolingo", "Coursera", "Udemy", "edX", "Skillshare", "MasterClass", "Lumosity", "Fitbit", "MyFitnessPal",
            "Strava", "Nike Training Club", "Calm", "Headspace", "Insight Timer", "Sleep Cycle", "Nike Run Club", "Runkeeper", "Map My Run", "Endomondo",
            "Uber Eats", "DoorDash", "Grubhub", "Postmates", "Deliveroo", "Just Eat", "Uber", "Lyft", "Bolt", "Ola",
            "Google Pay", "Apple Pay", "Samsung Pay", "Venmo", "PayPal", "Cash App", "Zelle", "Stripe", "Square", "Revolut",
            "Mint", "YNAB (You Need a Budget)", "Personal Capital", "Robinhood", "E*TRADE", "TD Ameritrade", "Coinbase", "Crypto.com", "Binance", "Kraken",
            "Amazon", "AliExpress", "eBay", "Walmart", "Target", "Best Buy", "Home Depot", "Costco", "Ikea", "Zalando",
            "Shazam", "SoundHound", "Musixmatch", "Genius", "Bandcamp", "Last.fm", "TuneIn Radio", "iHeartRadio", "Pandora", "Apple Music",
            "Google Calendar", "Microsoft Outlook", "Todoist", "Google Keep", "Trello", "Notion", "Any.do", "Asana", "Remember the Milk", "Evernote",
            "Google Docs", "Microsoft Word", "Google Sheets", "Microsoft Excel", "Google Slides", "Microsoft PowerPoint", "Zoho Docs", "Dropbox Paper", "Quip", "Notion",
            "Telegram", "WhatsApp", "Facebook Messenger", "Slack", "Skype", "Signal", "Zoom", "Discord", "Viber", "Microsoft Teams",
            "Google Photos", "Apple Photos", "OneDrive", "Google Drive", "Dropbox", "Box", "Mega", "pCloud", "Sync", "Nextcloud",
            "Slack", "Microsoft Teams", "Zoom", "Google Meet", "Skype", "Jitsi Meet", "Cisco Webex", "BlueJeans", "GoToMeeting", "RingCentral"
        ).map { it.lowercase() }

        //аналогично добавить список животных
        //список марок машин
        //марок видеокарт
        //бренды

        result = if (femaleNamesList.contains(textFieldText.lowercase())) "Это женское имя"
        else if (manNamesList.contains(textFieldText.lowercase())) "Это мужское имя"
        else if (carList.contains(textFieldText.lowercase())) "Это машина"
        else if (brandList.contains(textFieldText.lowercase())) "Это одежда"
        else if (animalList.contains(textFieldText.lowercase())) "Это животное"
        else if (appsList.contains(textFieldText.lowercase())) "Это приложение"
        else if (textFieldText.isNotBlank()) "Ты что-то написал"
        else "Пустота"



        TextField(textFieldText, { textFieldText = it })
        Spacer(Modifier.height(16.dp))
        Text(result, fontSize = 28.sp)
        Spacer(Modifier.height(16.dp))
        Text("Длина строки: ${textFieldText.length}", fontSize = 28.sp)
    }
}

const val GUESS_SCREEN = "Guess Screen"