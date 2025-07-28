import polyglot;

@polyglot.export_value
def message(name):
    return f"Hello {name} from GraalPy"