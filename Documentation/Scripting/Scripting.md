# LogicGateSystem Scripting Language Guide

This document defines the scripting language syntax for LogicGateSystem. It is designed to be simple, readable, and suitable for YAML files interpreted by Java.

---

## 🧾 Basic Structure (YAML)

Each logic circuit is written in YAML, with the logic expression defined using symbolic [operators](#Operators).

### Operators
- `&` = AND
- `|` = OR
- `!` = NOT (inversion)
- `~&` = NAND (negation of AND)
- `~|` = NOR (negation of OR)
- `^` = XOR (exclusive OR)
- `~^` = XNOR (negation of XOR)

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

### AND Gate
```yaml
safety_check:
  switch: Button1 & Button2
  output:
    true: "/tcc power On safety_channel"
    false: "/tcc power Off safety_channel"
```

### OR Gate
```yaml
launch_trigger:
  switch: LaunchButton | AdminOverride
  output:
    true: "/tcc power Toggle launch_channel"
```

### NOT Gate
```yaml
shutdown_safety:
  switch: !EmergencyStop & SystemReady
  output:
    true: "/tcc power On safety_channel"
    false: "/tcc power Off safety_channel"
```

### NAND Gate
```yaml
safety_check:
  switch: ~(SystemReady & EmergencyStop)
  output:
    true: "/tcc power On safety_channel"
    false: "/tcc power Off safety_channel"
```

### NOR Gate
```yaml
override_lock:
  switch: ~(AdminOverride | ManualOverride)
  output:
    true: "/tcc power On lock_channel"
    false: "/tcc power Off lock_channel"
```

### XOR Gate
```yaml
toggle_mode:
  switch: ModeA ^ ModeB
  output:
    true: "/tcc power Toggle mode_channel"
```

### XNOR Gate
```yaml
sync_check:
  switch: ~(ModeA ^ ModeB)
  output:
    true: "/tcc power On sync_channel"
    false: "/tcc power Off sync_channel"
```

### Complex Expression
```yaml
main_gate:
  switch: (GateActuation & AreaClear) | ManualGateActuation
  output:
    true: "/tcc power Pulse gate_channel"
```

---

## 🛠️ Implementation Notes
- The YAML file should be parsed into a `Map<String, LogicCircuit>` where each key is the circuit name.
- The `switch` string should be evaluated using a basic boolean expression parser.
- The `output` field should contain two commands: one for `true` and one for `false`.
- The commands should be executed based on the evaluation of the `switch` expression.
- The `switch` expression can include nested expressions and should be evaluated in a way that respects operator precedence.
- The parser should handle logical operators and parentheses correctly to ensure accurate evaluation.

## 🧩 Parsing and Execution
To implement the logic circuit system, follow these steps:
- Parse YAML into a `Map<String, LogicCircuit>`
- Evaluate the `switch` string using a basic boolean expression parser
- Execute the correct command from `output.get(true/false)`
- Handle exceptions and errors gracefully
- Log the results of command execution for debugging purposes
- Ensure that the system can handle concurrent evaluations and command executions
- Consider thread safety and synchronization if necessary
- Implement unit tests for the parser and command execution to ensure correctness

---
