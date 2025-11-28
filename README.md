# 📁 AutoSorter

AutoSorter is a simple and configurable Java application that automatically organizes files inside a directory based on rules defined in a `.properties` file.  
It scans a source folder and moves files into sub-folders depending on their extensions.

---

## ✨ Features

- 🔧 Fully configurable through `autosorter.properties`
- 📂 Creates destination folders automatically
- 🔍 Matches file extensions and sorts accordingly
- ⚠️ Error handling for invalid paths or permissions
- 🖥️ Works on any OS (Windows / Linux / macOS)
- 🪟 Uses small popup dialogs (JOptionPane) for messages

---

## 📦 How It Works

You provide an `autosorter.properties` file like this:

```
folder_path=C:\\Users\\YourUser\\Downloads
Images=.jpg,.png,.jpeg
Documents=.pdf,.docx,.txt
Videos=.mp4,.avi
Others=.zip,.rar
```

Each key corresponds to a target folder, and each value is a comma-separated list of extensions.

Then AutoSorter:

1. Reads the source folder path  
2. Loads the folder rules  
3. Creates subfolders if needed  
4. Moves matching files according to rules

---

## 🛠️ Project Files

- **App.java** → Main class, loads config, triggers sorting, shows messages  
- **AutoSorter.java** → Core sorting logic  
- **FolderRule.java** → Data model for target folder + extensions  
- **autosorter.properties** → Configuration file (created by the user)

---

## 🚀 How to Run

1. Compile:
```bash
javac *.java
```

2. Run:
```bash
java App
```

Make sure the file `autosorter.properties` is in the **same directory** as the compiled `.class` files.

---

## 📂 Example Folder Structure

```
AutoSorter/
├── App.java
├── AutoSorter.java
├── FolderRule.java
├── autosorter.properties
└── README.md
```

---

## 🤝 Contributions

Pull requests and improvements are welcome!

