import pyautogui as pyauto

# while True:
#     pyauto.keyDown('Mr')
#     pyauto.keyDown('k')
#     pyauto.keyDown('d')
#     pyauto.keyDown('k')

distance = 200
while distance > 0:
        pyauto.drag(distance, 0, duration=0.5)   # move right
        distance -= 5
        pyauto.drag(0, distance, duration=0.5)   # move down
        pyauto.drag(-distance, 0, duration=0.5)  # move left
        distance -= 5
        pyauto.drag(0, -distance, duration=0.5)  