# LogicGateSystem Scripting Language Guide

This document defines the scripting language syntax for LogicGateSystem. It is designed to be simple, readable, and suitable for YAML files interpreted by Java.

---

## 🧾 Basic Structure (YAML)

Each logic circuit is written in YAML, with the logic expression defined using symbolic [operators](#Operators).

### Operators
- `&` = AND
- `|` = OR
- `!` = NOT (inversion)

---

## 🔌 Fields Explained

### `switch` (required)
A logic expression combining inputs using symbolic [operators](#Operators).
- Use `&`, `|`, and `!` to define logic
- Inputs are treated as booleans (true/false)
- Parentheses `()` can be used to group expressions

### `output` (required)
The command to execute when the evaluated result is `true` or `false`.
- Should use `/tcc power <On|Off|Pulse|Toggle> <channel>`

---

## 🧪 Example Circuit

```yaml
restraints:
  switch: Power & TrainInStation & RestraintsButton
  output:
    true: "/tcc power On restraints_channel"
    false: "/tcc power Off restraints_channel"
```

---

## ⚙️ More Examples

### OR Gate with Toggle
```yaml
launch_trigger:
  switch: LaunchButton | AdminOverride
  output:
    true: "/tcc power Toggle launch_channel"
```

### Inverted Logic
```yaml
shutdown_safety:
  switch: !EmergencyStop & SystemReady
  output:
    true: "/tcc power On safety_channel"
    false: "/tcc power Off safety_channel"
```

### Complex Expression
```yaml
main_gate:
  switch: (GateActuation & AreaClear) | ManualGateActuation
  output:
    true: "/tcc power Pulse gate_channel"
```

---

## 🧠 Java Parsing Notes

Suggested class structure for parsing:

```java
class LogicCircuit {
    String switch;
    Map<Boolean, String> output;
}
```

- Parse YAML into a `Map<String, LogicCircuit>`
- Evaluate the `switch` string using a basic boolean expression parser
- Execute the correct command from `output.get(true/false)`

---

This format is powerful yet easy to write, offering flexible logic expressions and actionable command outputs.
