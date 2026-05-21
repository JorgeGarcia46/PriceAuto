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

consulta = pyautogui.locateCenterOnScreen(
    'testUI/Consultas.png',
    confidence=0.8
)

if consulta is not None:

    pyautogui.click(consulta)

    time.sleep(2)

consultaGeneral = pyautogui.locateCenterOnScreen(
    'testUI/consultaGeneral.png',
    confidence=0.8
)

if consultaGeneral is not None:

    pyautogui.click(consultaGeneral)

    time.sleep(2)

    print("La consulta se hizo correctamente")


    