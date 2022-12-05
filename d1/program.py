
with open("input.txt") as f:
    inputF = f.read()
    inventario = inputF.split("\n")
    elfos = [[]]
    elfo = 0
    for calorias in inventario:
        if calorias != '':
            elfos[elfo].append(int(calorias))
        else:
            elfo= elfo + 1
            elfos.append([])


    top = [0,]
    for elfo in elfos:
        cal =0
        for calor in elfo:
            cal = cal + calor
        if top[0] < cal:
            top.insert(0, cal)
        elif top[1] < cal:
            top.insert(1, cal)
        elif top[2] < cal:
            top.insert(2, cal)
    print(top[0]+top[1]+top[2])
    print(top)
