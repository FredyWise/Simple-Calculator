# Simple-Calculator


![image](https://github.com/FredyWise/Simple-Calculator/assets/84549992/2bbca335-f691-4db3-9e5e-8eb892830184)



## Description

Simple-Calculator is a modern, fully customizable calculator component for Android applications, built using Kotlin, Jetpack Compose, and Material3. It is designed to be easily integrated into various projects, providing a robust and aesthetically pleasing calculator UI and logic. Developers can tailor the look and feel to match their application's theme and can extend or replace the built-in ViewModel with their custom logic.

## Features

- **Customizable UI**: Easily adjust colors, shapes, and text styles to fit your application's design.
- **Flexible Logic**: Use the default ViewModel or integrate your custom ViewModel to handle calculator logic.
- **Composable Function**: Utilize the `SimpleBusinessCalculator` composable for seamless integration into Compose-based projects.
- **Open Source**: Extend and adapt the component as needed under the MIT license.

## Installation

To add Simple-Calculator to your project using JitPack, follow these steps:

### Step 1. Add the JitPack repository

Include JitPack in your project’s root `build.gradle` at the end of the repositories section:

```gradle
codedependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven(url = "https://www.jitpack.io")
    }
}
```

### Step 2. Add the Simple-Calculator dependency

Add the following line to your module's `build.gradle` dependencies:

```gradle
codedependencies {
    implementation("com.github.FredyWise:Simple-Calculator:Tag")
}
```

Replace `Tag` with the latest version tag from the [JitPack page](https://www.jitpack.io/#FredyWise/Simple-Calculator). You can find the most recent version there or automate this with a GitHub Action to always use the latest release.

For example, if the latest version is `0.0.9`, your dependency line will look like this:

```gradle
codedependencies {
    implementation("com.github.FredyWise:Simple-Calculator:0.0.9")
}
```

## Usage

Integrate the Simple-Calculator component into your application with ease:

### Basic Integration

To quickly add a basic calculator UI to your Compose project:

```
kotlinCopy codeimport com.simplecalculator.SimpleBusinessCalculator

@Composable
fun MyApp() {
    SimpleBusinessCalculator()
}
```

### Customizing the ViewModel

Use your custom ViewModel or modify the default one for personalized logic:

```kotlinCopy
codeimport com.simplecalculator.SimpleBusinessCalculator
import com.simplecalculator.CalculatorViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyCustomApp() {
    val customViewModel: CalculatorViewModel = viewModel()
    SimpleBusinessCalculator(calculatorViewModel = customViewModel)
}
```

Or initialize the ViewModel with specific parameters:

```
kotlinCopy codeimport com.simplecalculator.SimpleBusinessCalculator
import com.simplecalculator.CalculatorViewModel
import com.simplecalculator.CalculatorViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyFactoryApp() {
    val viewModel: CalculatorViewModel = viewModel(factory = CalculatorViewModelFactory("5", 10))
    SimpleBusinessCalculator(calculatorViewModel = viewModel)
}
```

### Customizing the UI

Tailor the calculator's appearance using various parameters:

```
kotlinCopy codeimport com.simplecalculator.SimpleBusinessCalculator
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp

@Composable
fun MyThemedApp() {
    SimpleBusinessCalculator(
        modifier = Modifier.padding(16.dp),
        btnSpacing = 12.dp,
        calculatorShape = RoundedCornerShape(8.dp),
        calcTextStyle = MaterialTheme.typography.bodyLarge,
        textColor = Color.White,
        textBackgroundColor = Color.DarkGray,
        calcBtnStyle = MaterialTheme.typography.button,
        buttonTextColor = Color.Yellow,
        numberButtonBackgroundColor = Color.Blue,
        operandButtonBackgroundColor = Color.Green,
        borderColor = Color.Red,
        buttonAspectRatio = 1.2f
    )
}
```

## Customization Options

The `SimpleBusinessCalculator` composable provides numerous parameters to customize its behavior and appearance:

- **modifier**: Modifier for the calculator layout.
- **btnSpacing**: Space between calculator buttons (`Dp`).
- **calculatorShape**: Shape of the calculator and its buttons.
- **calcTextStyle**: Text style for the main display.
- **textColor**: Color of the display text.
- **maxLine**: Maximum number of lines for the display text.
- **textBackgroundColor**: Background color for the display.
- **calcBtnStyle**: Text style for the calculator buttons.
- **buttonTextColor**: Color of the button text.
- **numberButtonBackgroundColor**: Background color for number buttons.
- **operandButtonBackgroundColor**: Background color for operand buttons.
- **borderColor**: Color of the borders around buttons.
- **buttonAspectRatio**: Aspect ratio of the buttons.
- **calculatorViewModel**: The ViewModel managing the calculator's logic.
- **leadingObject**: A composable for leading objects (e.g., icons) to be displayed in the calculator.

## Examples

Explore different ways to utilize Simple-Calculator:

### Basic Example

```
kotlinCopy codeimport com.simplecalculator.SimpleBusinessCalculator

@Composable
fun BasicCalculatorApp() {
    SimpleBusinessCalculator()
}
```

### Advanced Customization

```
kotlinCopy codeimport com.simplecalculator.SimpleBusinessCalculator
import com.simplecalculator.CalculatorViewModel

@Composable
fun AdvancedCalculatorApp() {
    val customViewModel = CalculatorViewModel()
    SimpleBusinessCalculator(
        calculatorViewModel = customViewModel,
        modifier = Modifier.padding(20.dp),
        btnSpacing = 15.dp,
        calculatorShape = MaterialTheme.shapes.medium,
        textColor = Color.Magenta,
        buttonTextColor = Color.Cyan
    )
}
```

### Themed Example

```
kotlinCopy codeimport com.simplecalculator.SimpleBusinessCalculator

@Composable
fun ThemedCalculatorApp() {
    SimpleBusinessCalculator(
        modifier = Modifier.padding(10.dp),
        btnSpacing = 8.dp,
        textColor = Color.Black,
        numberButtonBackgroundColor = Color.LightGray
    )
}
```

## Contributing

Contributions to Simple-Calculator are welcome. Here’s how you can get involved:

1. **Fork the repository** on GitHub.

2. Clone the repository

    to your local machine:

   ```
   sh
   Copy code
   git clone https://github.com/your-username/Simple-Calculator.git
   ```

3. Create a new branch

    for your changes:

   ```
   sh
   Copy code
   git checkout -b feature-branch
   ```

4. **Make your changes** in the relevant files.

5. Commit your changes

    with a clear and concise message:

   ```
   sh
   Copy code
   git commit -m "Brief description of your changes"
   ```

6. Push your changes

    to your forked repository:

   ```
   sh
   Copy code
   git push origin feature-branch
   ```

7. **Create a Pull Request (PR)** on the main repository.

Please ensure that your commits are descriptive and that your code follows the project's guidelines. 

## Support

For support, refer to this README file. If you have questions or encounter issues, please open an issue on our [GitHub Issues page](https://github.com/FredyWise/Simple-Calculator/issues).

## FAQs

### How do I customize the calculator’s appearance?

Use the parameters in the `SimpleBusinessCalculator` composable to adjust its appearance, including colors, shapes, text styles, and more.

### Can I use a different ViewModel with this calculator?

Yes, you can integrate your custom ViewModel or use the default provided ViewModel.

### Where can I find more examples?

Check the [Examples](#examples) section above for various integration scenarios and customizations.

## Project Status

Simple-Calculator is actively maintained. We welcome feedback and suggestions for new features. Stay tuned for updates and enhancements!
