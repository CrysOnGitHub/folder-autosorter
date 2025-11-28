# AutoSorter

AutoSorter is a simple Java utility that automatically organizes files inside a folder based on custom rules defined by the user.  
It reads sorting rules from a configuration file (`autosorter.properties`) and moves each file into a target subfolder depending on its extension.

This project uses plain Java (no frameworks) and is ideal as a lightweight personal automation tool.

---

## 🚀 Features

- Sort files automatically based on extension
- Customizable sorting rules via `.properties` file
- Creates target folders automatically if they do not exist
- Error handling with status codes and popup messages
- Non-destructive: files are only moved, not modified
- Cross-platform (Windows / macOS / Linux)

---

## 🗂️ How It Works

You define file–extension rules in a `autosorter.properties` file.  
Example:

```properties
folder_path=C:\\Users\\YourName\\Downloads
Images=.jpg,.png,.jpeg
Documents=.pdf,.txt,.docx
Music=.mp3,.wav
