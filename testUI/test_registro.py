import pyautogui
import time

time.sleep(5)

admin = pyautogui.locateCenterOnScreen(
    'testUI/admin.png',
    confidence=0.8
)

if admin is not None:

    pyautogui.click(admin)

    time.sleep(2)


    registro = pyautogui.locateCenterOnScreen(
        'testUI/registro.png',
        confidence=0.8
    )

    if registro is not None:

        pyautogui.click(registro)

        time.sleep(2)

        clave = pyautogui.locateCenterOnScreen(
            'testUI/campo_clave.png',
            confidence=0.8
        )

        pyautogui.click(clave)

        pyautogui.write('1001')


        marca = pyautogui.locateCenterOnScreen(
            'testUI/campo_marca.png',
            confidence=0.8
        )

        pyautogui.click(marca)

        pyautogui.write('Toyota')

        modelo = pyautogui.locateCenterOnScreen(
            'testUI/campo_modelo.png',
            confidence=0.8
        )

        pyautogui.click(modelo)

        pyautogui.write('Corolla')

        precio = pyautogui.locateCenterOnScreen(
            'testUI/campo_precio.png',
            confidence=0.8
        )

        pyautogui.click(precio)

        pyautogui.write('250000')


        year = pyautogui.locateCenterOnScreen(
            'testUI/campo_year.png',
            confidence=0.8
        )

        pyautogui.click(year)

        pyautogui.write('2024')


        cantidad = pyautogui.locateCenterOnScreen(
            'testUI/campo_cantidad.png',
            confidence=0.8
        )

        pyautogui.click(cantidad)


        registrar = pyautogui.locateCenterOnScreen(
            'testUI/registrar.png',
            confidence=0.8
        )

        pyautogui.click(registrar)

        print("Vehiculo registrado correctamente")