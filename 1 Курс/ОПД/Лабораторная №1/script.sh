#5001
./cleaner.sh # удаление файлов с предыдущего запуска скрипта

#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Первый пункт задания. Создание файлов и каталогов.
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
mkdir lab0
cd lab0

# Работа с каталогом foongus4 и файлами/каталогами внутри него
mkdir foongus4
mkdir foongus4/sawsbuck
mkdir foongus4/carvanha
echo "Тип диеты Carnivore" > foongus4/houndoom # создание и заполнение файла houndoom содержимым согласно условию

# Работа с каталогом mienfoo6 и файлами/каталогами внутри него 
mkdir mienfoo6
mkdir mienfoo6/galvantula
mkdir mienfoo6/hoothoot
cat << EOF > mienfoo6/munchlax
Развитые способности
Gluttony
EOF
   
# Работа с файлом poliwag5
echo "satk=4 sdef=4 spd=9" > poliwag5 # заполнение файла содержимым согласно условию

# Работа с каталогом poochyena7 и файлами/каталогами внутри него
mkdir poochyena7
mkdir poochyena7/kabutops
mkdir poochyena7/magneton
echo "weight-20.9 height=47.0 atk=9 def=12" > poochyena7/weezing
cat << EOF > poochyena7/galvantula
Тип диеты
:Carnivore
EOF
cat << EOF > poochyena7/blaziken
Ходы
Blast Burn Body Slam Bounce Counter Double-Edge Dual Chop Dynamicpunch
Fire Pledge Fire Punch Focus Punch Fury Cutter Heat Wave Helping Hand
Hi Jump Kick Knock Off Last Resort Low Kick Magic Coat Mega Kick Mega
Punch Mirror Move Mud-Slap Rock Climb Role Play Seismic Toss Sleep
Talk Snore Superpower Swift Thunderpunch Vacuum Wave
EOF

# Работа с файлом rufflet7
cat << EOF > rufflet7
satk=4
sdef=5
spd=6
EOF

# Работа с файлом wailord4
cat << EOF > wailord4
Способносjти Growl Water Gun Rollout Whirlpool
Astonish Water Pulse Mist Rest Brine Water Spout Amnesia Dive Bounce
Hydro Pump Heavy Slam
EOF
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Второй пункт задания. Выдача прав файлам.
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
chmod 771 foongus4
chmod u=rwx,g=wx,o=wx foongus4/sawsbuck
chmod 512 foongus4/carvanha
chmod 620 foongus4/houndoom

chmod u=wx,g=rwx,o=rx mienfoo6
chmod u=rx,g=rwx,o=rw mienfoo6/galvantula
chmod 640 mienfoo6/munchlax
chmod u=rwx,g=rw,o=r mienfoo6/hoothoot

chmod u=r,g=r,o= poliwag5

chmod 555 poochyena7
chmod 440 poochyena7/galvantula
chmod a=rwx poochyena7/kabutops
chmod 444 poochyena7/weezing
chmod 044 poochyena7/blaziken
chmod 311 poochyena7/magneton

chmod 666 rufflet7
chmod u=,g=rw,o=w wailord4
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Третий пункт задания. Копирование файлов и создание ссылок.
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
chmod u+wx poliwag5
chmod u+rx mienfoo6
cp poliwag5 mienfoo6/munchlaxpoliwag
ln -sf poliwag5 mienfoo6/munchlaxpoliwag
chmod u-wx poliwag5
cp poliwag5 poochyena7/kabutops
cat poochyena7/weezing poochyena7/galvantula > poliwag5_24

chmod u+w poochyena7
ln rufflet7 poochyena7/weezingrufflet
chmod u-w poochyena7 

ln -s foongus4 Copy_51

cp -r mienfoo6 mienfoo67
cp -r mienfoo67 mienfoo6/hoothoot
rm -rf mienfoo67
# cp -r mienfoo6 mienfoo6/hoothoot невозможно, так директория будет копироваться сама в себя до бесконечности

chmod u+rx poochyena7/magneton
echo -e "\nДерево после пункта 3:\n"
ls -lR
chmod u-rx mienfoo6
chmod u-rx poochyena7/magneton
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Четвёртый пункт задания. Работа с файлами и сортировка.
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
echo "1. Подсчет количества символов содержимого файлов: houndoom, munchlax, galvantula:"
wc -m foongus4/houndoom mienfoo6/munchlax poochyena7/galvantula poochyena7/weezing 2>/dev/null | sort -r

echo "2. Рекурсивный вывод список имен и атрибутов файлов в директории lab0, содержащих строку 'po':"
ls -Rl | grep "po" | sort -n -k6 -r

echo "3. Вывод содержимого файла wailord4 с номерами строк, заканчивающиеся на 'e':"
cat wailord4 | grep -i 'e$' -n 2>&1

echo "4. Вывод четырех последних элементов рекурсивного списка имен и атрибутов файлов в директории lab0, заканчивающихся на символ 'a':"
ls -lR | grep ".*a$" | head -n 4

echo "5. Подсчёт количества символов содержимого файла rufflet7, запись результата в тот-же файл."
wc -m rufflet7 >> rufflet7

echo "6. Рекурсивный вывод файлов из lab0, имя которых заканчивается на '7':"
ls -d *7 */*7 */*/*7 | sort 

#--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Пятый пункт задания. Удаление файлов и каталогов.
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
rm rufflet7
chmod u+w poochyena7
rm -f poochyena7/weezing
rm -f mienfoo6/munchlaxpoliw*
rm -f poochyena7/weezingruffl*
chmod -R 777 mienfoo6 && rm -r mienfoo6
chmod -R u+w poochyena7/kabutops && rm -r poochyena7/kabutops

chmod u+r poochyena7/magneton
echo -e "\nДерево после пункта 5:\n"
ls -lR
