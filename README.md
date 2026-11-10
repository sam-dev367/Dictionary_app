# 📖 DictionaryApp

A clean and efficient native Android dictionary application built with Java and XML. This app connects to the Free Dictionary REST API to provide users with real-time definitions, parts of speech, and linguistic examples.

---

## 🚀 Features

* **Instant Word Search:** Query any English word to fetch live definitions from an external web service.
* **Structured Results:** Displays words organized clearly by their parts of speech (noun, verb, adjective, etc.) and individual definitions.
* **Asynchronous Networking:** Uses **Retrofit** and **Gson** to handle background API requests without freezing the UI thread.
* **Robust Error Handling:** Provides user-friendly Toasts and error messages for invalid words or network connectivity issues.

---

## 🛠️ Tech Stack & Libraries

* **Language:** Java
* **UI Layout:** Android XML Views (`LinearLayout`, `ScrollView`, `EditText`, `TextView`)
* **Networking:** Retrofit 2 (`com.squareup.retrofit2:retrofit`)
* **JSON Parsing:** Gson Converter (`com.squareup.retrofit2:converter-gson`)
* **Architecture / API:** RESTful API consumption via the [Free Dictionary API](https://dictionaryapi.dev/)

---

## 📂 Project Architecture

```text
com.example.dictionaryapp/
│
├── api/
│   ├── DictionaryApi.java       # Retrofit interface defining endpoint routes
│   └── RetrofitClient.java      # Singleton client configuration for Retrofit
│
├── models/
│   ├── Definition.java          # POJO class for individual definitions and examples
│   ├── Meaning.java             # POJO class mapping parts of speech and definitions
│   └── WordResult.java          # Root POJO class mapping the main word response
│
└── MainActivity.java            # Main UI controller handling user input and API calls

