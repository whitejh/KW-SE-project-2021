import os
import enum

from sqlalchemy import Column, String, Enum
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import scoped_session, sessionmaker

db_engine = create_engine(f"postgresql://postgres:{os.environ['PG_PW']}@db")

session = scoped_session(sessionmaker(bind=db_engine))

Base = declarative_base()


class Role(enum.Enum):
    ADMIN = 'ADMIN'
    CONSUMER = 'CONSUMER'
    SELLER = 'SELLER'
    
class Member(Base):
    __tablename__ = 'member'

    id: str = Column(String, primary_key=True)
    email: str = Column(String, nullable=False)
    role: enum.Enum = Column(Enum(Role), default=Role.CONSUMER)

    def __repr__(self):
        return f'<{self.id} @ {self.email}>'
