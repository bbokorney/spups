from sys import argv


def add_new_space():
    ret = "loc = new HexLocation(new ArrayList<Directions>(directions));\n"
    ret += "space = new JavaSpace();\n"
    ret += "board.placeSpace(loc, space);\n"
    return ret


script, input_filename, output_filename = argv

lines = open(input_filename, "r").read().split()
output = ""
for line in lines:
    if line == "ORIGIN":
        output += "List<Directions> directions = new ArrayList<Directions>();\n"
        output += "HexLocation loc;\n"
        output += "Space space;\n"
        output += add_new_space()
    elif line == "NORTH":
        output += "directions.add(Directions.NORTH);\n"
        output += add_new_space()
    elif line == "SOUTH":
        output += "directions.add(Directions.SOUTH);\n"
        output += add_new_space()
    elif line == "NORTHEAST":
        output += "directions.add(Directions.NORTHEAST);\n"
        output += add_new_space()
    elif line == "NORTHWEST":
        output += "directions.add(Directions.NORTHWEST);\n"
        output += add_new_space()
    elif line == "SOUTHEAST":
        output += "directions.add(Directions.SOUTHEAST);\n"
        output += add_new_space()
    elif line == "SOUTHWEST":
        output += "directions.add(Directions.SOUTHWEST);\n"
        output += add_new_space()
    elif line == "IRRIGATION":
        output += add_new_space()
        output += "board.placeIrrigationTileComponent(loc, new IrrigationTileComponent(new Tile(1)));\n"
    elif line == "HIGHLANDS":
        output += add_new_space()
        output += "board.addToHighlands(loc);\n"
    elif line == "LOWLANDS":
        output += add_new_space()
        output += "board.addToLowlands(loc);\n"
    else:
        print "Don't understand %r" % line

open(output_filename, "w").write(output)


