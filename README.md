<div align="center">

# Отчёт

</div>

<div align="center">

## Практическая работа №9

</div>

<div align="center">

## Создание меню

</div>

**Выполнил:**  
Ткачев Сергей Юрьевич  
**Курс:** 2  
**Группа:** ИНС-б-о-24-2  
**Направление:** ИПИНЖ (Институт перспективной инженерии)  
**Профиль:** Информационные системы и технологии  

---

### Цель работы

Изучить способы создания и обработки событий от различных типов меню в Android-приложении: главного меню `OptionsMenu` и контекстного меню `ContextMenu`. Научиться динамически изменять интерфейс приложения с помощью пунктов меню.

---

### Ход работы

#### Задание 1: Создание проекта и подготовка интерфейса

1. Был открыт Android Studio и создан новый проект с шаблоном **Empty Views Activity**.
2. Проекту было дано имя `PW_9`.
3. В качестве языка программирования был выбран **Java**.
4. Package name проекта был задан как:

```text
com.ncfu.pw_9
```

5. Согласно варианту 5 необходимо реализовать:
- главное меню для изменения размера текста `TextView`;
- три предустановленных размера текста;
- контекстное меню на `TextView`;
- перемещение текста выше и ниже с помощью изменения `layout_marginTop`.

6. В файле `activity_main.xml` был создан интерфейс приложения.
7. На экран был добавлен `Toolbar`, чтобы отобразить главное меню приложения через три точки.
8. Также был добавлен `TextView`, для которого будут выполняться действия из главного и контекстного меню.

#### Листинг 1. Содержимое файла `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#6750A4"
        android:title="Практическая работа №9"
        android:titleTextColor="#FFFFFF"
        app:titleTextColor="#FFFFFF" />

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="24dp">

        <TextView
            android:id="@+id/tvMenuText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Практическая работа №9"
            android:textSize="24sp"
            android:textStyle="bold"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="250dp" />

    </FrameLayout>

</LinearLayout>
```

<div align="center">

<img width="430" height="791" alt="Снимок экрана 2026-05-09 181742" src="https://github.com/user-attachments/assets/0b4ba054-3c6b-4271-9b90-117be1bf9e4a" />

*Рисунок 1. Главный экран приложения с текстом и верхней панелью меню*

</div>

---

#### Задание 2: Создание главного меню OptionsMenu

1. В папке `res` была создана папка `menu`.
2. В папке `res/menu` был создан файл `main_menu.xml`.
3. В главное меню были добавлены три пункта:
- **Маленький текст**;
- **Средний текст**;
- **Большой текст**.

4. Каждый пункт меню отвечает за установку определённого размера текста в `TextView`.

#### Листинг 2. Содержимое файла `res/menu/main_menu.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/action_small_text"
        android:title="Маленький текст"
        app:showAsAction="never" />

    <item
        android:id="@+id/action_medium_text"
        android:title="Средний текст"
        app:showAsAction="never" />

    <item
        android:id="@+id/action_large_text"
        android:title="Большой текст"
        app:showAsAction="never" />

</menu>
```

5. В `MainActivity.java` был переопределён метод `onCreateOptionsMenu()`.
6. С помощью метода `getMenuInflater().inflate()` меню было подключено к Activity.
7. Для обработки нажатий на пункты меню был переопределён метод `onOptionsItemSelected()`.

<div align="center">

<img width="386" height="794" alt="image" src="https://github.com/user-attachments/assets/5076a070-77ea-4695-833d-c188d5b9f704" />

*Рисунок 2. Главное меню с пунктами изменения размера текста*

</div>

<div align="center">

<img width="395" height="798" alt="image" src="https://github.com/user-attachments/assets/da04324d-4ca5-4e19-99f7-e388c94524d2" />

*Рисунок 3. Результат выбора пункта главного меню*

</div>

---

#### Задание 3: Создание контекстного меню ContextMenu

1. В папке `res/menu` был создан файл `context_menu.xml`.
2. В контекстное меню были добавлены два пункта:
- **Переместить выше**;
- **Переместить ниже**.

3. Контекстное меню вызывается при долгом нажатии на `TextView`.
4. При выборе пункта **Переместить выше** значение верхнего отступа уменьшается.
5. При выборе пункта **Переместить ниже** значение верхнего отступа увеличивается.

#### Листинг 3. Содержимое файла `res/menu/context_menu.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/context_move_up"
        android:title="Переместить выше" />

    <item
        android:id="@+id/context_move_down"
        android:title="Переместить ниже" />

</menu>
```

6. В методе `onCreate()` элемент `TextView` был зарегистрирован для контекстного меню с помощью метода `registerForContextMenu()`.
7. Для создания контекстного меню был переопределён метод `onCreateContextMenu()`.
8. Для обработки выбора пунктов контекстного меню был переопределён метод `onContextItemSelected()`.

<div align="center">

<img width="393" height="804" alt="image" src="https://github.com/user-attachments/assets/989429f3-33b9-4a28-bcdb-5a144440a0e8" />

*Рисунок 4. Контекстное меню для TextView*

</div>

<div align="center">

<img width="400" height="790" alt="image" src="https://github.com/user-attachments/assets/0b64fa80-8f61-4715-94e4-4e6e258b22ef" />

*Рисунок 5. Результат перемещения текста по экрану*

</div>

---

#### Задание 4: Реализация логики приложения

1. В `MainActivity.java` была реализована работа с главным меню и контекстным меню.
2. Для подключения верхней панели был использован `Toolbar`.
3. Главное меню изменяет размер текста:
- маленький размер — `18sp`;
- средний размер — `24sp`;
- большой размер — `32sp`.

4. Контекстное меню изменяет положение текста на экране.
5. Для изменения положения используется переменная `topMargin`.
6. При перемещении текста выше значение `topMargin` уменьшается на `50`.
7. При перемещении текста ниже значение `topMargin` увеличивается на `50`.
8. Для применения нового отступа используется метод `setLayoutParams()`.

#### Листинг 4. Код файла `MainActivity.java`

```java
package com.ncfu.pw_9;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvMenuText;

    private int topMargin = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMenuText = findViewById(R.id.tvMenuText);

        registerForContextMenu(tvMenuText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_small_text) {
            tvMenuText.setTextSize(18);
            Toast.makeText(this, "Выбран маленький размер текста", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_medium_text) {
            tvMenuText.setTextSize(24);
            Toast.makeText(this, "Выбран средний размер текста", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_large_text) {
            tvMenuText.setTextSize(32);
            Toast.makeText(this, "Выбран большой размер текста", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.tvMenuText) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
            menu.setHeaderTitle("Действия с текстом");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.context_move_up) {
            moveTextUp();
            Toast.makeText(this, "Текст перемещён выше", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.context_move_down) {
            moveTextDown();
            Toast.makeText(this, "Текст перемещён ниже", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    private void moveTextUp() {
        topMargin -= 50;

        if (topMargin < 0) {
            topMargin = 0;
        }

        updateTextMargin();
    }

    private void moveTextDown() {
        topMargin += 50;

        if (topMargin > 600) {
            topMargin = 600;
        }

        updateTextMargin();
    }

    private void updateTextMargin() {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) tvMenuText.getLayoutParams();
        params.topMargin = topMargin;
        tvMenuText.setLayoutParams(params);
    }
}
```

---

#### Задание 5: Объединение и тестирование

1. Приложение было запущено на эмуляторе Pixel 6.
2. Было проверено, что главный экран приложения отображается корректно.
3. При нажатии на три точки в верхней панели открывается главное меню.
4. Были проверены пункты главного меню:
- **Маленький текст**;
- **Средний текст**;
- **Большой текст**.

5. После выбора пунктов главного меню размер текста изменяется.
6. При долгом нажатии на `TextView` открывается контекстное меню.
7. Были проверены пункты контекстного меню:
- **Переместить выше**;
- **Переместить ниже**.

8. После выбора пунктов контекстного меню текст перемещается по экрану.

---

### Вывод

В результате выполнения практической работы были изучены способы создания и обработки событий от различных типов меню в Android-приложении. Было реализовано главное меню `OptionsMenu`, которое позволяет изменять размер текста `TextView` с помощью трёх предустановленных вариантов.

Также было создано контекстное меню `ContextMenu`, которое вызывается при долгом нажатии на `TextView`. С помощью пунктов контекстного меню было реализовано перемещение текста выше и ниже по экрану за счёт изменения параметра `layout_marginTop`.

В ходе работы были получены навыки создания XML-файлов меню в папке `res/menu`, подключения меню к Activity, обработки выбора пунктов меню, а также динамического изменения интерфейса приложения. Цель практической работы была достигнута.

---

### Ответы на контрольные вопросы

1. **Какие типы меню существуют в Android? Опишите их назначение.**

   В Android существуют разные типы меню.

   **OptionsMenu** — главное меню приложения. Обычно оно открывается через три точки в верхней панели приложения и используется для общих действий, которые относятся ко всему экрану или приложению.

   **ContextMenu** — контекстное меню. Оно появляется при долгом нажатии на конкретный элемент интерфейса и содержит действия, связанные именно с этим элементом.

   **PopupMenu** — всплывающее меню, которое привязывается к определённому `View` и появляется рядом с ним после нажатия.

---

2. **Как создать главное меню OptionsMenu? Какие методы необходимо переопределить в Activity?**

   Для создания главного меню нужно создать XML-файл меню в папке `res/menu`, например `main_menu.xml`.

   После этого в Activity нужно переопределить метод `onCreateOptionsMenu()` и загрузить меню:

   ```java
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main_menu, menu);
       return true;
   }
   ```

   Для обработки выбора пунктов меню используется метод `onOptionsItemSelected()`:

   ```java
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

       if (id == R.id.action_small_text) {
           tvMenuText.setTextSize(18);
           return true;
       }

       return super.onOptionsItemSelected(item);
   }
   ```

---

3. **Для чего используется атрибут app:showAsAction? Какие значения он может принимать?**

   Атрибут `app:showAsAction` определяет, как пункт меню будет отображаться в верхней панели приложения.

   Основные значения:
- `never` — пункт всегда находится в выпадающем меню;
- `ifRoom` — пункт отображается на панели, если есть свободное место;
- `always` — пункт всегда отображается на панели;
- `withText` — показывает пункт вместе с текстом, если это возможно.

   В данной работе использовалось значение:

   ```xml
   app:showAsAction="never"
   ```

   Это означает, что пункты меню отображаются в выпадающем меню после нажатия на три точки.

---

4. **Как зарегистрировать View для контекстного меню? В каком методе это обычно делается?**

   Чтобы зарегистрировать элемент интерфейса для контекстного меню, используется метод `registerForContextMenu()`.

   Обычно это делается в методе `onCreate()`:

   ```java
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       tvMenuText = findViewById(R.id.tvMenuText);
       registerForContextMenu(tvMenuText);
   }
   ```

   После этого при долгом нажатии на зарегистрированный элемент будет вызываться контекстное меню.

---

5. **В чём разница между методами onCreateContextMenu и onContextItemSelected?**

   Метод `onCreateContextMenu()` отвечает за создание и отображение контекстного меню. В нём можно загрузить XML-файл меню и задать заголовок.

   Пример:

   ```java
   @Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       super.onCreateContextMenu(menu, v, menuInfo);
       getMenuInflater().inflate(R.menu.context_menu, menu);
       menu.setHeaderTitle("Действия с текстом");
   }
   ```

   Метод `onContextItemSelected()` отвечает за обработку выбора пункта контекстного меню.

   Пример:

   ```java
   @Override
   public boolean onContextItemSelected(MenuItem item) {
       if (item.getItemId() == R.id.context_move_up) {
           moveTextUp();
           return true;
       }

       return super.onContextItemSelected(item);
   }
   ```

---

6. **Как создать контекстное меню динамически, без использования XML-ресурса?**

   Контекстное меню можно создать программно с помощью метода `menu.add()`.

   Пример:

   ```java
   @Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       super.onCreateContextMenu(menu, v, menuInfo);

       menu.setHeaderTitle("Действия");
       menu.add(0, 1, 0, "Переместить выше");
       menu.add(0, 2, 1, "Переместить ниже");
   }
   ```

   В этом случае пункты меню создаются прямо в Java-коде, без отдельного XML-файла в папке `res/menu`.

---

7. **Что возвращают методы onOptionsItemSelected и onContextItemSelected? Что означает возврат true?**

   Методы `onOptionsItemSelected()` и `onContextItemSelected()` возвращают значение типа `boolean`.

   Если метод возвращает `true`, это означает, что выбранный пункт меню был обработан, и событие дальше передавать не нужно.

   Если метод возвращает `false` или вызывается `super`, это означает, что событие не было полностью обработано текущим методом.

   Пример:

   ```java
   if (id == R.id.action_large_text) {
       tvMenuText.setTextSize(32);
       return true;
   }

   return super.onOptionsItemSelected(item);
   ```

---

8. **Как определить, для какого именно элемента было вызвано контекстное меню, если зарегистрировано несколько View?**

   Для определения элемента, который вызвал контекстное меню, можно использовать параметр `View v` в методе `onCreateContextMenu()`.

   Пример:

   ```java
   @Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       super.onCreateContextMenu(menu, v, menuInfo);

       if (v.getId() == R.id.tvMenuText) {
           getMenuInflater().inflate(R.menu.context_menu, menu);
       }
   }
   ```

   Если контекстное меню используется для элементов списка, можно использовать объект `menuInfo`, например `AdapterView.AdapterContextMenuInfo`.
