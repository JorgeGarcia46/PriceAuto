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

    bajas_menu = pyautogui.locateCenterOnScreen(
        'testUI/bajas.png',
        confidence=0.8
    )

    if bajas_menu is not None:

        pyautogui.click(bajas_menu)

        time.sleep(2)

        # Buscar campo clave
        campo_clave = pyautogui.locateCenterOnScreen(
            'testUI/buscarbaja.png',
            confidence=0.8
        )

        if campo_clave is not None:

            pyautogui.click(campo_clave)

            pyautogui.write('1001')

            time.sleep(1)

            boton_bajas = pyautogui.locateCenterOnScreen(
                'testUI/eliminar.png',
                confidence=0.8
            )

            if boton_bajas is not None:

                pyautogui.click(boton_bajas)

                print("Vehiculo eliminado correctamente")

            else:
                print("No se encontró el botón Bajas")

        else:
            print("No se encontró el campo clave")

    else:
        print("No se encontró el módulo Bajas")

else:
    print("No se encontró el botón Admin")