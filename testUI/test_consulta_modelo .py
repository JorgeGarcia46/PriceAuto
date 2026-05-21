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

consultaModelo = pyautogui.locateCenterOnScreen(
    'testUI/consultaModelo.png',
    confidence=0.8
)

if consultaModelo is not None:

    pyautogui.click(consultaModelo)

    time.sleep(2)

campoModelo = pyautogui.locateCenterOnScreen(
    'testUI/campoModelo.png',
    confidence=0.8
)

if campoModelo is not None:

    pyautogui.click(campoModelo)
    pyautogui.write('Corolla')

    time.sleep(2)

   

buscar = pyautogui.locateCenterOnScreen(
    'testUI/buscar.png',
    confidence=0.8
)

if buscar is not None:

    pyautogui.click(buscar)
   
    time.sleep(2)

    print("La consulta se hizo correctamente")
